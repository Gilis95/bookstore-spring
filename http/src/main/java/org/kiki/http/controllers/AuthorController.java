package org.kiki.http.controllers;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.business.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

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
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void createAuthor(@RequestParam AuthorDTO dto) {
    }


    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully update author entry")
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAuthor(@PathVariable long id, @RequestParam AuthorDTO dto) {
    }

    @ResponseStatus(value = HttpStatus.OK, reason = "Successfully deleted author entry")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteAuthor(@PathVariable long id) {
    }
}
