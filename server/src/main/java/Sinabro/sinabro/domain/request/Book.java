package Sinabro.sinabro.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    @Column
    private String publisher;
    @Column
    private String subject;
    @Column
    private Long chapter;

    public Book() {
    }

    public String getSource(){
        String s=this.getSubject()+" - "+this.getPublisher()+" - "+this.getChapter();
        return s;
    }

    public Book(String publisher, String subject, Long chapter) {
        this.publisher = publisher;
        this.subject = subject;
        this.chapter = chapter;
    }

}
