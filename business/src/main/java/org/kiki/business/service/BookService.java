package org.kiki.business.service;

import org.kiki.business.dto.BookDTO;
import org.kiki.database.dao.BookDAO;
import org.kiki.database.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    public Flux<BookDTO> findAll() {
        return bookRepository.findAll().map(bookDAO -> mapper.map(bookDAO, BookDTO.class));
    }

    public Mono<BookDAO> createEntry(BookDTO bookDTO)
    {
        var updateDao = mapper.map(bookDTO, BookDAO.class);
        return bookRepository.save(updateDao);
    }

    public Mono<Integer> updateEntry(long id, BookDTO bookDTO)
    {
        var updateDao = mapper.map(bookDTO, BookDAO.class);
        return bookRepository.update(id, updateDao);
    }

    public Mono<Void> deleteEntry(long id) {
        return bookRepository.deleteById(id);
    }
}
