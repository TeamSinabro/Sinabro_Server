package Sinabro.sinabro.domain.Repository;



import Sinabro.sinabro.domain.Voca;
import Sinabro.sinabro.domain.response.VocaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VocaRepository extends JpaRepository<Voca, Long> {

    @Query(value = "SELECT * FROM voca_table voca WHERE voca.publisher=:publisher and voca.subject=:subject and voca.chapter=:chpater", nativeQuery = true)
    VocaResponse findByVoca(String publisher, String subject, int chapter);
}


