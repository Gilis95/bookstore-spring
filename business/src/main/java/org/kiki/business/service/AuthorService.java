package org.kiki.business.service;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.database.dao.AuthorDAO;
import org.kiki.database.dao.BookDAO;
import org.kiki.database.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ModelMapper mapper;

    public Flux<AuthorDTO> findAll() {
        return authorRepository.findAll().map(authorDAO -> mapper.map(authorDAO, AuthorDTO.class));
    }

    public Mono<AuthorDTO> createEntry(AuthorDTO bookDTO)
    {
        var updateDao = mapper.map(bookDTO, AuthorDAO.class);
        return authorRepository
                .save(updateDao)
                .filter(Objects::nonNull)
                .map(authorDAO -> mapper.map(authorDAO, AuthorDTO.class));
    }

    public Mono<Integer> updateEntry(long id, AuthorDTO bookDTO)
    {
        var updateDao = mapper.map(bookDTO, AuthorDAO.class);
        return authorRepository.update(id, updateDao);
    }

    public Mono<Void> deleteEntry(long id) {
        return authorRepository.deleteById(id);
    }
}
