package Sinabro.sinabro.Controller;


import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.VocaLearningService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
//@Component
@RequestMapping("/voca")
@RequiredArgsConstructor
public class VocaController {
    private final VocaRepository vocaRepository;
    private VocaLearningService vocaLearningService;
    @ResponseBody
    @GetMapping("/problem")
    public String userProblem(@RequestParam() String publisher, @RequestParam() String subject,
                              @RequestParam int chapter, Model model){


        log.info("subject={}, publisher={}, chapter={}",subject,publisher,chapter);

        int maximumBound=vocaRepository.findByVocaCount(publisher,subject);

        log.info("maximumBound={}",maximumBound);

        Random random=new Random();
        List<Integer> problemVid=new ArrayList<>();
        int i=0;
        while(i<5){
            log.info("while문 진입");
            int temp=random.nextInt(maximumBound);
            System.out.println("temp = " + temp);
            if(problemVid.contains(temp)) continue;
            problemVid.add(1);
            problemVid.add(temp);
            break;
            //i++;
        }
        log.info("while문 끝");
        List<String> vocaList=vocaRepository.findByProblem(problemVid);

        log.info("어휘학습서비스 실행 완");

        String answer= vocaList.get(0);
        log.info("answer={}",answer);

        //model.addAttribute("problem",problem);
        //model.addAttribute("vocaDefinition",vocaDefinition);
        model.addAttribute("optionList",vocaList);
        model.addAttribute("answer",answer);
        //model.addAttribute("answerSource",answerSource);
        return "ok"; //http 메세지 바디에 바로 입력
   }
/*
    @GetMapping("/answer")
    public String userAnswer(){
        return "/voca"; //아직 못 정함 --> ?어디로 가는지..?
    }*/
/*
    @GetMapping("/search/{Vid}")
    public String voca(@PathVariable Long Vid, Model model) {
        //Voca voca=vocaRepository.findByVid(Vid);
        //String word = voca.getWord();
        //model.addAttribute("voca", voca);
        //log.info("search={}",word);
        return "/voca/search/{word}/content";  //임의로 설정
    }
*/
}
