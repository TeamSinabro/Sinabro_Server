package Sinabro.sinabro.service;

import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.response.VocaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VocaService {

    private final VocaRepository vocaRepository;


    public VocaResponse getVocaResponse(String publisher, String subject, int chapter){
        return vocaRepository.findByVoca(publisher, subject, chapter);
    }

}