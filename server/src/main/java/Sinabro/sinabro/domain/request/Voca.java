package Sinabro.sinabro.domain.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Voca {
    private Long vid;

    private String publisher;

    private String subject;

    private int chapter;


    public Voca(int chapter, String publisher, String subject) {
        this.chapter = chapter;
        this.publisher = publisher;
        this.subject = subject;
    }
}
