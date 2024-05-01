package br.com.tiagoprudente.literalura.model;

import br.com.tiagoprudente.literalura.service.api.dto.Results;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> author;

    private String bookTitle;

    private ArrayList<String> languages;

    public Book() {
    }

    public Book(UUID id, List<Author> author, String bookTitle, ArrayList<String> languages) {
        this.id = id;
        this.author = author;
        this.bookTitle = bookTitle;
        this.languages = languages;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public Book fromBookData(List<Results> data) {
        return new Book(UUID.randomUUID(), Author.fromAuthorData(data.get(0).authors()), data.get(0).title(), (ArrayList<String>) data.get(0).languages());
    }
}
