package Sinabro.sinabro.service;

import Sinabro.sinabro.api.ApiDict;
import Sinabro.sinabro.domain.Repository.BookRepository;
import Sinabro.sinabro.domain.Repository.SentenceRepository;
import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.request.Sentence;
import Sinabro.sinabro.domain.request.Voca;
import Sinabro.sinabro.domain.response.PronunciationResponse;
import Sinabro.sinabro.domain.response.SearchResponse;
import Sinabro.sinabro.domain.response.VocaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class VocaService {

    @Autowired //스프링부트가 미리 생성해 놓은 객체를 가져다가 연결
    private final VocaRepository vocaRepository;
    private final BookRepository bookRepository;
    private final SentenceRepository sentenceRepository;
    public ApiDict apiDict=new ApiDict();
    private Random random=new Random();

    public Sentence getProblem(String publisher, String subject, int chapter){
        int bid=bookRepository.findByPublisherAndSubjectAndChapter(publisher, subject, chapter);
        log.info("bid={}",bid);
        List<Sentence> sentenceList =sentenceRepository.findByBid(bid);
        int index=random.nextInt(sentenceList.size()-1);
        Sentence sentence=sentenceList.get(index);
        return sentence;
    }
    public VocaResponse getVocaResponse(String publisher, String subject, int chapter){

        Sentence sentence=getProblem(publisher,  subject,  chapter);
        String problem= sentence.getSentence();
        //문장에 있는 단어 랜덤 뽑기
        List<Voca> vocaList=vocaRepository.findBySid(sentence.getSid());
        int index=random.nextInt(vocaList.size()-1);
        Voca voca=vocaList.get(index);
        String answer=voca.getVoca();
        //형태소 동일한 오답 생성
        List<String> candidateList=vocaRepository.findByMorpheme(voca.getMorpheme());
        List<String> optionList = new ArrayList<String>();
        optionList.add(answer);
        int i=0;
        while(i<3){
            index=random.nextInt(candidateList.size()-1);
            if(optionList.contains(candidateList.get(index))) {
                continue;
            }
            optionList.add(candidateList.get(index));
            i++;
        }
        Collections.shuffle(optionList);
        //단어 정의 -> 사전 API 사용부분
        List<String> vocaDefinition=apiDict.findeDefinition(answer); // 지금 필요없기도함
        String answerSource=voca.getApply();
        //log.info("vocaDefinition={}",vocaDefinition);

        VocaResponse vocaResponse=new VocaResponse(problem, vocaDefinition, optionList,  answer,  answerSource);
        return vocaResponse;
        //언어 유사도 분석??  좋아하다 좋아한
        //가다 갔다 ..?
    }

    public PronunciationResponse getpronunciationResponse(String publisher, String subject, int chapter){
        Sentence sentence=getProblem(publisher,  subject,  chapter);
        PronunciationResponse pronunciationResponse=new PronunciationResponse(sentence.getSentence());
        return pronunciationResponse;
    }

    public SearchResponse getVocaContent(String keyword){
        List<String> vocaDefinition=apiDict.findeDefinition(keyword);
        List<Integer> sidL=vocaRepository.findByVoca(keyword); //null일 경우 생각해보기
        List<String> sentence=new ArrayList<String>();
        List<String> keywordSource=new ArrayList<String>();
        List<Integer> trashL=new ArrayList<>();
        int i=0;
        int index=0;

        if(sidL.size()<4){
            for(Integer id : sidL){
                sentence.add(sentenceRepository.findBySid(id).getSentence());
                keywordSource.add(bookRepository.findByBid(sentenceRepository.findBySid(id).getBid()).getSource());
            }
        }
        while(i<3 & sidL.size()>3 ){
            index=random.nextInt(sidL.size()-1);
            if(trashL.contains(index)) {
                continue;
            }
            trashL.add(index);
            sentence.add(sentenceRepository.findBySid(sidL.get(index)).getSentence());
            keywordSource.add(bookRepository.findByBid(sentenceRepository.findBySid(sidL.get(index)).getBid()).getSource());
            i++;
        }

        SearchResponse searchResponse=new SearchResponse(vocaDefinition,  sentence, keywordSource);
        return  searchResponse;
    }


}