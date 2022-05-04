package Sinabro.sinabro.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "voca_table")
public class Voca {
    @Id
    private Long vid;
    private String word;
    private String publisher;
    private String subject;
    private String chapter;

    public Voca(Long vid){
    }

    public Voca(String word, String publisher, String subject) {
        this.word = word;
        this.publisher = publisher;
        this.subject = subject;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
