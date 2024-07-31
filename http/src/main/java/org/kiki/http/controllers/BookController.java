package org.kiki.http.controllers;

import org.kiki.business.dto.BookDTO;
import org.kiki.business.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public Flux<BookDTO> listBooks() {
        return bookService.findAll();
    }
}
