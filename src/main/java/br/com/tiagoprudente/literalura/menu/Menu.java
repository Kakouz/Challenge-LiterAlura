package br.com.tiagoprudente.literalura.menu;

import br.com.tiagoprudente.literalura.model.Book;
import br.com.tiagoprudente.literalura.service.api.GutendexAPIService;
import br.com.tiagoprudente.literalura.service.api.IBookAPI;
import br.com.tiagoprudente.literalura.service.api.dto.BookData;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Scanner;

@Component
public class Menu {
    private final IBookAPI api = new GutendexAPIService();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            show("Bem vindo a LiterAlura");
            show("Escolha a opção desejada");

            show("1 - Buscar por autor");

            show("0 - Sair");

            String option = this.sc.nextLine();

            switch (option) {
                case "1" -> findByAuthor();

                case "0" -> System.exit(0);
                default -> show("Opção invalida tente novamente");
            }
        }
    }

    private void findByAuthor() {
        HashMap<String, String> params = new HashMap<>();
        show("Digite o nome do Autor(a)!");
        String author = sc.nextLine();
        params.put("author", author);

        Book resp = new Book().fromBookData(this.api.execute(params).results());

        show(resp.getBookTitle());
    }

    private void show(String msg) {
        System.out.println(msg);
    }

}
