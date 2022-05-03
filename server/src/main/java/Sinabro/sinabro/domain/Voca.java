package Sinabro.sinabro.domain;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Voca {
    private Long vid;
    private String word;
    private String definition;

    public Voca(Long vid){
    }

    public Voca(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public Long getVid() {
        return vid;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
