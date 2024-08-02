package org.kiki.http.controllers;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.business.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public Flux<AuthorDTO> listAuthors() {
        return authorService.findAll();
    }

    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully created author entry")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<AuthorDTO> createAuthor(@RequestBody AuthorDTO dto) {
        return authorService.createEntry(dto);
    }


    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully update author entry")
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> updateAuthor(@PathVariable long id, @RequestBody AuthorDTO dto) {
        return authorService.updateEntry(id, dto);
    }

    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully deleted author entry")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public Mono<Void> deleteAuthor(@PathVariable long id) {
        return authorService.deleteEntry(id);
    }
}
