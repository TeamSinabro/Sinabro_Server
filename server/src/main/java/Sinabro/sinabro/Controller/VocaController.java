package SinabroLocal.LocalSina.Controller;

import SinabroLocal.LocalSina.domain.Repository.VocaRepository;
import SinabroLocal.LocalSina.domain.Voca;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/voca")
@RequiredArgsConstructor
public class VocaController {
    private final VocaRepository vocaRepository;

    // @ResponseBody json 파일 전달같이 일반적인 변수 전달 아닐 시 사용
    @GetMapping("/problem")
    public String userProblem(@RequestParam() String publisher, @RequestParam() String subject, @RequestParam int chapter){
        log.info("subject={}, publisher={}, chapter={}",subject,publisher,chapter);
// DB -> 데이터 -> Voca Question 랜덤 -> 데이터 -> 클라


        return "ok";
    }

    @GetMapping("/answer")
    public String userAnswer(){
        return "/voca"; //아직 못 정함 --> ?어디로 가는지..?
    }

    @GetMapping("/search/{Vid}")
    public String voca(@PathVariable Long Vid, Model model) {
        Voca voca = vocaRepository.findByVid(Vid);
        String word = voca.getWord();
        model.addAttribute("voca", voca);
        log.info("search={}",word);
        return "/voca/search/{word}/content";  //임의로 설정
    }

}
