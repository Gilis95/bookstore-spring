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
        createAuthorMapper();
        createBookMapper();

        return bookRepository.findAll().map(bookDAO -> mapper.map(bookDAO, BookDTO.class));
    }

    private void createAuthorMapper() {
        TypeMap<AuthorDAO, AuthorDTO> authorDaoToDtoMap = mapper.getTypeMap(AuthorDAO.class, AuthorDTO.class);
        if(authorDaoToDtoMap == null) {
            authorDaoToDtoMap = mapper.createTypeMap(AuthorDAO.class, AuthorDTO.class);
        }

        authorDaoToDtoMap.setProvider(request -> {
            AuthorDAO source = AuthorDAO.class.cast(request.getSource());
            return new AuthorDTO(source.getId(), source.getName(),source.getBirthDate(), null);
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
