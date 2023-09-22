package com.piece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class PieceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PieceApplication.class, args);
	}

}
