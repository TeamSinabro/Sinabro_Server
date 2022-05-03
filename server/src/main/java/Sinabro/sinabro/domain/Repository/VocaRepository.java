package Sinabro.sinabro.domain.Repository;

import Sinabro.sinabro.domain.Voca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //DB와 연동되는 저장소 역할
public class VocaRepository {
    private static final Map<Long, Voca> store = new HashMap<>(); //static
    //실제로는 HashMap 사용하면 안됨 -> 멀티쓰레드 환경 동시 접근 가능하게 됨
    private static long sequence = 0L; //static

    public Voca save(Voca voca){
        voca.setVid(++sequence);
        store.put(voca.getVid(),voca);
        return voca;
    }
    public Voca findByVid(Long vid){
        return store.get(vid);
    }
    public List<Voca> findAll(){
        return new ArrayList<>(store.values());
    }
    public void update(Long vocaId,Voca updateParam){ //단어 정의 추가
        Voca findVoca=findByVid(vocaId);
        findVoca.setDefinition(updateParam.getDefinition());
    }
    public void clearStore(){
        store.clear(); //HashMap 데이터 다 날라감
    }
}
