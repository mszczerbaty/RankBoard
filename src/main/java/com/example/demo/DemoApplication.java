package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BoardGameRepo boardGameRepo){
		return args -> {
			Stream.of("Diuna","Pan Lodowego Ogrodu", "Wsiasc do pociagu").forEach(boardgamename -> {
				BoardGame boardGame = new BoardGame(boardgamename);
				boardGameRepo.save(boardGame);
			});
			boardGameRepo.findAll().forEach(System.out::println);
		};
	}
}
