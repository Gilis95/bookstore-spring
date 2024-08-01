package org.kiki.database.repository;

import jakarta.persistence.*;
import org.kiki.database.dao.BookDAO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface BookRepository extends ReactiveCrudRepository<BookDAO, Long> {
    @Query("{ 'title': ?0}")
    Mono<BookDAO> findBookByTitle(String title);

    @Modifying
    @Query("UPDATE book SET title = :#{#dao.getTitle()}, description = :#{#dao.getDescription()}, release_date = :#{#dao.getReleaseDate()}, author_id = :#{#dao.getAuthor() != null ? #dao.getAuthor().getId() : null} where id = :#{#id}")
    Mono<Integer> update(@Param("id") long id, @Param("dao") BookDAO dao);
}
