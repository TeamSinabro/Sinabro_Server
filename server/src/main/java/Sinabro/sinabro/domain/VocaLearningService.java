package Sinabro.sinabro.domain;

import Sinabro.sinabro.domain.Repository.VocaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@RequiredArgsConstructor
public class VocaLearningService {
    private final VocaRepository vocaRepository;

    private static long sequence = 0L; //static
//문서에서 단어와 문장 디비에 저장하는!
    /*
    public void vocaSave(){
        Voca voca=new Voca();
        vocaRepository.save(voca);
    }

*/

}
