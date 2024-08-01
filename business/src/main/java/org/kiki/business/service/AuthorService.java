package org.kiki.business.service;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.database.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;

    @Autowired
    ModelMapper mapper;

    public Flux<AuthorDTO> findAll() {
        return repository.findAll().map(authorDAO -> mapper.map(authorDAO, AuthorDTO.class));
    }
}
