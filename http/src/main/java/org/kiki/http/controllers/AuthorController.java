package org.kiki.http.controllers;


import org.kiki.business.dto.AuthorDTO;
import org.kiki.business.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/authors")
    public Flux<AuthorDTO> listAuthors() {
        return authorService.findAll();
    }
}
