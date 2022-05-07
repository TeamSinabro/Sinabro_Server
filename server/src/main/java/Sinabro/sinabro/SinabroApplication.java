package Sinabro.sinabro;


import Sinabro.sinabro.domain.Repository.SentenceRepository;
import Sinabro.sinabro.domain.Repository.VocaRepository;
import Sinabro.sinabro.domain.Sentence;
import Sinabro.sinabro.domain.request.Voca;
import Sinabro.sinabro.domain.dbhandler.CsvReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;


@RequiredArgsConstructor
@SpringBootApplication
public class SinabroApplication {//implements CommandLineRunner {
	@Autowired
	private final VocaRepository vocaRepository;
	private final SentenceRepository sentenceRepository;
	public static void main(String[] args) {
		SpringApplication.run(SinabroApplication.class, args);
	}
	/*
	@Override
	public void run(String...args) throws Exception {
		CsvReader csvReader = new CsvReader();
		String path1="/Users/hyerim/AI융캡디2/DB/지학사_사회1_220508.csv";
		String path2="/Users/hyerim/AI융캡디2/DB/지학사_사회1_220508_문장.csv";

		for (List<String> i : csvReader.readCSV(path2)) { //for문을 통한 전체출력
			System.out.println(i);
			String s = i.get(1);
			System.out.println("s = " + s);
			String s2=i.get(2);
			System.out.println("s2 = " + s2);

			int bid = Integer.parseInt(s2);
			Sentence sentence = new Sentence(s,bid);
			sentenceRepository.save(sentence);
		}


		for (List<String> j : csvReader.readCSV(path1)) { //for문을 통한 전체출력
			String vocaname = j.get(1);
			String str = j.get(2);
			String morpheme=j.get(3);
			System.out.println("morpheme = " + morpheme);

			List<String> list = Arrays.asList(str.replace('"','/').split("/"));
			for(String sid:list){
				//System.out.println("sid = " + sid);
				Voca voca = new Voca(vocaname,parseInt(sid),morpheme);
				vocaRepository.save(voca);
			}
		}
	}*/
}
