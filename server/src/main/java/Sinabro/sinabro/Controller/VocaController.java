package Sinabro.sinabro.Controller;


import Sinabro.sinabro.domain.request.Voca;
import Sinabro.sinabro.domain.response.VocaResponse;
import Sinabro.sinabro.service.VocaService;
import Sinabro.sinabro.util.ResponseService;
import Sinabro.sinabro.util.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //ResponseBody 내장됨
@RequestMapping("/voca")
@RequiredArgsConstructor
public class VocaController {

    private final VocaService vocaService;
    private final ResponseService responseService;
    // @ResponseBody json 파일 전달같이 일반적인 변수 전달 아닐 시 사용
    // DB -> 데이터 -> Voca Question 랜덤 -> 데이터 -> 클라

    @GetMapping("/problem")
    public SingleResponse<VocaResponse> userProblem(@RequestParam() String publisher, @RequestParam() String subject, @RequestParam int chapter){
        log.info("subject={}, publisher={}, chapter={}",subject,publisher,chapter);
        //서비스 호출
        //각각 넣기
        return responseService.getSingleResponse(vocaService.getVocaResponse(publisher, subject, chapter));
    }

    @GetMapping("/answer")
    public String userAnswer(){
        return "/voca"; //아직 못 정함 --> ?어디로 가는지..?
    }

    @GetMapping("/search/{Vid}")
    public String voca(@PathVariable Long Vid, Model model) {



        return "/voca/search/{word}/content";  //임의로 설정
    }

}
