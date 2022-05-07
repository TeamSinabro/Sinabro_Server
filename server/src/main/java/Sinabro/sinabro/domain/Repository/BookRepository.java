package Sinabro.sinabro.domain.Repository;

import Sinabro.sinabro.domain.Book;
import Sinabro.sinabro.domain.request.Voca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select bid from book_table where publisher=:publisher and subject=:subject and chapter=:chapter",nativeQuery = true)
    public int findByPublisherAndSubjectAndChapter(String publisher, String subject, int chapter);
}
