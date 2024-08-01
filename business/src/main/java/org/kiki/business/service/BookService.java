package org.kiki.business.service;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.business.dto.BookDTO;
import org.kiki.database.dao.AuthorDAO;
import org.kiki.database.dao.BookDAO;
import org.kiki.database.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    public Flux<BookDTO> findAll() {
        return bookRepository.findAll().map(bookDAO -> mapper.map(bookDAO, BookDTO.class));
    }
}
