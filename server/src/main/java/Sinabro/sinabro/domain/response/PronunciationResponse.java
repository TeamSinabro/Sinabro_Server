package Sinabro.sinabro.domain.response;

import lombok.Data;

@Data
public class PronunciationResponse {
    private  String problem;

    public PronunciationResponse(String problem) {
        this.problem = problem;
    }
}
