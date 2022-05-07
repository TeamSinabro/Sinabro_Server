package Sinabro.sinabro.domain.dbhandler;


import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.Voca;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class VocaHandler implements CommandLineRunner {
    @Autowired
    private final VocaRepository vocaRepository;
    public static void main(String[] args) {
        SpringApplication.run(VocaHandler.class, args);
    }
    @Override
    public void run(String...args) throws Exception {
        CsvReader csvReader = new CsvReader();
        for (List<String> i : csvReader.readCSV()) { //for문을 통한 전체출력

            String temp = i.get(1);
            Voca voca = new Voca(temp);
            vocaRepository.save(voca);
            break;
        }
    }
}
