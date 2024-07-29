package org.kiki.http.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookstoreController {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/bookstore")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
