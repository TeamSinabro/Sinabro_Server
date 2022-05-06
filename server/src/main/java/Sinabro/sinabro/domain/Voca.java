package Sinabro.sinabro.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "voca_table")
public class Voca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vid;
    @Column
    private String voca;
    @Column
    private Long sid; //문장 고유번호


    public Voca(){
    }

    public Voca(String voca) {
        this.voca = voca;
    }

    public Voca(String voca, Long sid) {
        this.voca = voca;
        this.sid = sid;
    }

    public Long getVid() {
        return vid;
    }

    public String getVoca() {
        return voca;
    }

    public void setVoca(String voca) {
        this.voca = voca;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}
