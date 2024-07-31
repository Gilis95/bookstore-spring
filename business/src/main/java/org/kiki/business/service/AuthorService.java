package org.kiki.business.service;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.business.dto.BookDTO;
import org.kiki.database.dao.AuthorDAO;
import org.kiki.database.dao.BookDAO;
import org.kiki.database.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;

    @Autowired
    ModelMapper mapper;

    public Flux<AuthorDTO> findAll() {
        return repository.findAll().map(authorDAO -> mapper.map(authorDAO, AuthorDTO.class));
    }

    private void createAuthorMapper() {
        TypeMap<AuthorDAO, AuthorDTO> authorDaoToDtoMap = mapper.getTypeMap(AuthorDAO.class, AuthorDTO.class);
        if(authorDaoToDtoMap == null) {
            authorDaoToDtoMap = mapper.createTypeMap(AuthorDAO.class, AuthorDTO.class);
        }

        authorDaoToDtoMap.setProvider(request -> {
            AuthorDAO source = AuthorDAO.class.cast(request.getSource());
            var books = source
                    .getBooks()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(bookDAO -> mapper.map(bookDAO, BookDTO.class))
                    .toList();

            return new AuthorDTO(source.getId(), source.getName(),source.getBirthDate(), books);
        });
    }

    private void createBookMapper() {
        TypeMap<BookDAO, BookDTO> bookDaoToDtoMap = mapper.getTypeMap(BookDAO.class, BookDTO.class);
        if(bookDaoToDtoMap == null) {
            bookDaoToDtoMap = mapper.createTypeMap(BookDAO.class, BookDTO.class);
        }

        bookDaoToDtoMap.setProvider(request -> {
            var source = BookDAO.class.cast(request.getSource());
            var authorDTO = source.getAuthor() == null ? null : mapper.map(source.getAuthor(), AuthorDTO.class);
            return new BookDTO(source.getId(), source.getTitle(),source.getDescription(),source.getReleaseDate(),
                    authorDTO);
        });
    }
}
