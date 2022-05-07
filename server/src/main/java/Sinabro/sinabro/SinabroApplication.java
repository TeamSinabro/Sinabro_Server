package Sinabro.sinabro;


import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.Voca;
import Sinabro.sinabro.domain.dbhandler.CsvReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@RequiredArgsConstructor
@SpringBootApplication
public class SinabroApplication implements CommandLineRunner {

	@Autowired
	private final VocaRepository vocaRepository;
	public static void main(String[] args) {
		SpringApplication.run(SinabroApplication.class, args);

	}
	@Override
	public void run(String...args) throws Exception {
		CsvReader csvReader = new CsvReader();
		for (List<String> i : csvReader.readCSV()) { //for문을 통한 전체출력
			if(i.get(1)=="word") continue;
			String temp = i.get(1);
			Voca voca = new Voca(temp);
			vocaRepository.save(voca);
		}
		System.out.println("complete");
	}
}
