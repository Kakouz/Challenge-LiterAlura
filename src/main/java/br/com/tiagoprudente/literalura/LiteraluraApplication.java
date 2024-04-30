package br.com.tiagoprudente.literalura;

import br.com.tiagoprudente.literalura.service.api.GutendexAPI;
import br.com.tiagoprudente.literalura.service.api.IBookAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IBookAPI api = new GutendexAPI();

		String resp = api.execute();
		System.out.println(resp);
	}
}
