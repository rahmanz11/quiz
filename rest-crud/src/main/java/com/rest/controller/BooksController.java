package com.rest.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.model.Book;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/rest")
@RestController
public class BooksController {

    private static List<Book> books = new ArrayList<>();
    private static int Id = 1;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/book/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable("Id") int Id) {
        if (books == null || books.isEmpty()) {
            return null;
        } else {
            return books.stream()
                    .filter(b -> b.getId() == Id)
                    .findFirst()
                    .get();
        }
    }

    @DeleteMapping("/book/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("Id") int Id) {
        books.removeIf(f -> f.getId() == Id);
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {
        if (books == null || books.isEmpty()) {
            books = new ArrayList();
        }
        if (book.getId() == 0) {
            book.setId(++Id);
        } else {
            Id = book.getId();
        }
        books.add(book);
        return book;
    }

    @PutMapping("/book")
    @ResponseStatus(HttpStatus.OK)
    private Book update(@RequestBody Book book) {
        if (books == null && books.isEmpty()) {
            return book;
        } else {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    b.setTitle(book.getTitle());
                    b.setDate(book.getDate());
                    return b;
                }
            }
        }

        return null;
    }
}
