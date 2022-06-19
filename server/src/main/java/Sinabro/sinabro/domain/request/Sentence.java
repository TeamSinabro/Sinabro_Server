package Sinabro.sinabro.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sentence")
public class Sentence {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) 지금은 자동 할당 X
    private int sid;
    @Column
    private String sentence;
    @Column
    private int bid;

    public Sentence() {
    }
    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence(int sid, String sentence, int bid) {
        this.sid = sid;
        this.sentence = sentence;
        this.bid = bid;
    }

    public Sentence(int sid) {
        this.sid = sid;
    }

    public Sentence(String sentence, int bid) {
        this.sentence = sentence;
        this.bid = bid;
    }


    public int getSid() {
        return sid;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
