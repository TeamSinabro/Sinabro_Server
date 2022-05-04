package Sinabro.sinabro.domain;

import Sinabro.sinabro.domain.Repository.VocaRepository;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class VocaLearningService {
    private final VocaRepository vocaRepository;

    private static long sequence = 0L; //static


    //검색한 단어가 지정한 교과서 몇 챕터에 나오는지 확인
    public String findByChapter(String voca, String publisher,String subject){
        return vocaRepository.findByVocaAndPublisherAndSubject(voca,publisher,subject);
    }

  /*  // 다의어..? 출력 ..?
    public List<Voca> findByByVoca(String voca){
        return new ArrayList<>(vocaRepository.findByVoca(voca));
    }*/

    //문제 생성 -> 일단 한번에 5문제로 제한
    public List<String> generateProblem(String publisher,String subject){
        int maximumBound=vocaRepository.findByVocaCount(publisher,subject);
        Random random=new Random();
        List<Integer> problemVid=new ArrayList<>();
        int i=0;
        while(i<5){
            int temp=random.nextInt(maximumBound);
            if(problemVid.contains(temp)) continue;
            problemVid.add(temp);
            i++;
        }
        List<String> vocaList=vocaRepository.findByProblem(problemVid);
        return vocaList;
    }

}
