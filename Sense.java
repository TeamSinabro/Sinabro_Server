package api;

import lombok.Data;
@Data
public class Sense {
    private String definition;
    private String enWord;
    private String enDefinition;

    public Sense(String definition, String trans_word, String trans_dfn) {
    }
}