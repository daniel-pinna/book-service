package br.dev.pinna.controller;

import br.dev.pinna.environment.InstanceInformationService;
import br.dev.pinna.model.Book;
import br.dev.pinna.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        String port = informationService.retrieveServerPort();

        var book = repository.findById(id).orElseThrow();

        book.setEnvironment(port);
        book.setCurrency(currency);

        return book;
    }
}
