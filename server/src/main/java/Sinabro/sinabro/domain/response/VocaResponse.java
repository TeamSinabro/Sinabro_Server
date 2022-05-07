package Sinabro.sinabro.domain.response;

import lombok.Data;

import java.util.List;

@Data
public class VocaResponse {
    private  String problem;

    private  String vocaDefinition;

    private  List<String> optionList;

    private  String answer;

    private  String answerSource;


    public VocaResponse(String problem, String vocaDefinition, List<String> optionList, String answer, String answerSource) {
        this.problem = problem;
        this.vocaDefinition = vocaDefinition;
        this.optionList = optionList;
        this.answer = answer;
        this.answerSource = answerSource;
    }
}
