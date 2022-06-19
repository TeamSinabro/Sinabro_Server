package Sinabro.sinabro.domain.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "voca")
public class Voca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vid;
    @Column
    private String voca;
    @Column
    private int sid; //문장 고유번호
    @Column
    private String morpheme;
    @Column
    private String apply;


    public Voca(){
    }


    public Voca(String voca, int sid, String morpheme) {
        this.voca = voca;
        this.sid = sid;
        this.morpheme = morpheme;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public int getVid() {
        return vid;
    }
    public String getVoca() {
        return voca;
    }
    public void setVoca(String voca) {
        this.voca = voca;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getMorpheme() {
        return morpheme;
    }
    public void setMorpheme(String morpheme) {
        this.morpheme = morpheme;
    }
}
