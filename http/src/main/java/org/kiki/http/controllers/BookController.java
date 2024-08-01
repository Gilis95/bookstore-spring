package org.kiki.http.controllers;

import org.kiki.business.dto.BookDTO;
import org.kiki.business.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public Flux<BookDTO> listBooks() {
        return bookService.findAll();
    }

    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully created book entry")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDTO dto) {
        System.out.println(dto.toString());
    }


    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully update book entry")
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> updateBook(@PathVariable long id, @RequestBody BookDTO dto) {
        return bookService.updateEntry(id, dto);
    }

    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully deleted book entry")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteBook(@PathVariable long id) {
    }
}
