package Sinabro.sinabro.domain.Repository;

import Sinabro.sinabro.domain.Sentence;
import Sinabro.sinabro.domain.Voca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository  extends JpaRepository<Sentence, Integer> {
    @Query(value="select * from sinabro.sentence where vocaname=:vocaname",nativeQuery = true)
    Sentence findByEmailAddress(@Param("vocaname") String vocaname); //복,단수 and Null 유무 파악
}
