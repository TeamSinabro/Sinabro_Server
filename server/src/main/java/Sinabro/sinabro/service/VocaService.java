package Sinabro.sinabro.service;

import Sinabro.sinabro.domain.Repository.BookRepository;
import Sinabro.sinabro.domain.Repository.SentenceRepository;
import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.Sentence;
import Sinabro.sinabro.domain.request.Voca;
import Sinabro.sinabro.domain.response.VocaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class VocaService {

    @Autowired //스프링부트가 미리 생성해 놓은 객체를 가져다가 연결
    private final VocaRepository vocaRepository;
    private final BookRepository bookRepository;
    private final SentenceRepository sentenceRepository;

    public VocaResponse getVocaResponse(String publisher, String subject, int chapter){
        int bid=bookRepository.findByPublisherAndSubjectAndChapter(publisher, subject, chapter);
        List<Sentence> sentenceList =sentenceRepository.findByBid(bid);
        Random random=new Random();
        int index=random.nextInt(sentenceList.size()-1);
        Sentence sentence=sentenceList.get(index);

        String problem= sentence.getSentence();
        //문장에 있는 단어 랜덤 뽑기
        List<Voca> vocaList=vocaRepository.findBySid(sentence.getSid());
        index=random.nextInt(vocaList.size()-1);
        Voca voca=vocaList.get(index);
        String answer=voca.getVoca();
        //형태소 동일한 오답 생성
        List<String> optionList=vocaRepository.findByMorpheme(voca.getMorpheme());
        //단어 정의 -> 사전 API 사용부분
        String vocaDefinition="샘플 단어 정의가 설명되어있는 부분입니다."; // 지금 필요없기도함
        String answerSource="어떤 교과서 어떤 과목 몇 챕터 / 페이지가 표시되는 부분입니다.";

        VocaResponse vocaResponse=new VocaResponse(problem, vocaDefinition, optionList,  answer,  answerSource);
        return vocaResponse;
    }

    /*public VocaResponse getVocaResponse(String publisher, String subject, int chapter){
        return vocaRepository.findByVoca(publisher, subject, chapter);
    }*/

}