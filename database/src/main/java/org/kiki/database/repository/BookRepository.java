package org.kiki.database.repository;

import org.kiki.database.dao.BookDAO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<BookDAO, Long> {
    @Query("{ 'title': ?0}")
    Mono<BookDAO> findBookByTitle(String title);
}
