package Sinabro.sinabro.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity //데이터를 담기위한 객체 생성
@Table(name = "sentence")
public class Sentence {
    private Long sid;
    private String word;
    private Integer page;
    private String sentence1;

    public Long getSid() {
        return sid;
    }
}
