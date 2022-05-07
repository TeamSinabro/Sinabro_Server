package Sinabro.sinabro.Controller;


import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.response.VocaResponse;
import Sinabro.sinabro.service.VocaService;
import Sinabro.sinabro.util.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import Sinabro.sinabro.util.SingleResponse;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/voca")
@RequiredArgsConstructor
public class VocaController {
    private final VocaService vocaService;
    private final ResponseService responseService;


    @ResponseBody
    @GetMapping("/problem")
    public SingleResponse<VocaResponse> userProblem(@RequestParam() String publisher, @RequestParam() String subject,
                                                    @RequestParam int chapter){

        log.info("subject={}, publisher={}, chapter={}",subject,publisher,chapter);


        return responseService.getSingleResponse(vocaService.getVocaResponse(publisher, subject, chapter));
   }

   // 어휘-출판사-과목을 이용해 몇 챕터에서 이 단어 나오는지 확인
   /* public String findByChapter(String voca, String publisher,String subject){
        return vocaRepository.findByVocaAndPublisherAndSubject(voca,publisher,subject);
    }

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
