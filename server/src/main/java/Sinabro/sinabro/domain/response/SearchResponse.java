package Sinabro.sinabro.domain.response;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {
    private  List<String> vocaDefinition;
    private  List<String> sentence; //String으로 있어야 할거같음
    private  String keywordSource;

    public SearchResponse() {
    }

    public SearchResponse(List<String> vocaDefinition) {
        this.vocaDefinition = vocaDefinition;
    }

    public SearchResponse(List<String> vocaDefinition, List<String> sentence, String keywordSource) {
        this.vocaDefinition = vocaDefinition;
        this.sentence = sentence;
        this.keywordSource = keywordSource;
    }
}
