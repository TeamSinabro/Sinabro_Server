package Sinabro.sinabro.domain.Repository;

import Sinabro.sinabro.domain.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    @Query()
    public List<Sentence> findByBid(int bid);


}
//- 어휘 <- 문장  <- 교과서
// 문장 랜덤으로 뽑음 -> id 로 어휘 select -> 나머지 어휘 3개도 무작위
// 마스킹 방법 고민 (그자리에서 형태소분석 / 이미 다 들어가있기) -> 단어 3개 랜덤으로 뽑음(이건 출판사 상관없음) ->
// 단어 테이블에 형태소도 추가해야함