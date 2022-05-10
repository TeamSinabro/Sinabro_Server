package Sinabro.sinabro.Controller;


import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.response.PronunciationResponse;
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


    @GetMapping("/pronunciation")
    public SingleResponse<PronunciationResponse> pronunciationProblem(@RequestParam() String publisher, @RequestParam() String subject,
                                                                      @RequestParam int chapter){

        log.info("subject={}, publisher={}, chapter={}",subject,publisher,chapter);

        return responseService.getSingleResponse(vocaService.getpronunciationResponse(publisher, subject, chapter));
    }
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
