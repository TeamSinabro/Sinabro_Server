package Sinabro.sinabro.domain.Repository;

import Sinabro.sinabro.domain.request.Voca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository //DB와 연동되는 저장소 역할
public interface VocaRepository extends JpaRepository<Voca, Long> {
    //@Query(value = "select chapter from voca_table where voca=:voca and publisher=:publisher and subject=:subject",nativeQuery = true)
    //public String findByVocaAndPublisherAndSubject(String voca, String publisher, String subject);

    //@Query(value = "select count(vid) from voca_table where publisher=:publisher and subject=:subject",nativeQuery = true)
    //public int findByVocaCount(@Param("publisher") String publisher, @Param("subject") String subject);

    @Query(value = "select voca from voca_table where vid in :vid",nativeQuery = true)
    List<String> findByProblem(List<Integer> vid);

    @Query
    List<Voca> findBySid(int sid);

    @Query(value = "select voca from voca_table where morpheme=:morpheme",nativeQuery = true)
    List<String> findByMorpheme(String morpheme);



}
