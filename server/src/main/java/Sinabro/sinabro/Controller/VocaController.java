package Sinabro.sinabro.Controller;

import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.Voca;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
//@Component
@RequestMapping("/voca")
@RequiredArgsConstructor
public class VocaController {
    //private final VocaRepository vocaRepository;

    // @ResponseBody json 파일 전달같이 일반적인 변수 전달 아닐 시 사용
    //모델 객체를 이용해서 뷰에 데이터 전달 가능
    //Model 을 이용하고, 뷰 이름 반환
    @GetMapping("/problem")
    public String userProblem(@RequestParam() String publisher, @RequestParam() String subject,
                              @RequestParam int chapter, Model model){
        log.info("subject={}, publisher={}, chapter={}",subject,publisher,chapter);
// DB -> 데이터 -> Voca Question 랜덤 -> 데이터 -> 클라
        String problem="사회";
        String vocaDefinition="사회";
        List<String> optionList=new ArrayList<>();
        optionList.add("사회");
        optionList.add("수학");
        String answer="사회";
        String answerSource="사회";

        model.addAttribute("problem",problem);
        model.addAttribute("vocaDefinition",vocaDefinition);
        model.addAttribute("optionList",optionList);
        model.addAttribute("answer",answer);
        model.addAttribute("answerSource",answerSource);
        return "ok"; //http 메세지 바디에 바로 입력
   }

    @GetMapping("/answer")
    public String userAnswer(){
        return "/voca"; //아직 못 정함 --> ?어디로 가는지..?
    }

    @GetMapping("/search/{Vid}")
    public String voca(@PathVariable Long Vid, Model model) {
        //Voca voca=vocaRepository.findByVid(Vid);
        //String word = voca.getWord();
        //model.addAttribute("voca", voca);
        //log.info("search={}",word);
        return "/voca/search/{word}/content";  //임의로 설정
    }

}
