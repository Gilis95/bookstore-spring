package org.kiki.database.repository;

import org.kiki.database.dao.AuthorDAO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<AuthorDAO, Long> {
    @Modifying
    @Query("UPDATE book SET name = :#{#dao.getName()}, birth_date = :#{#dao.getBirthDate()}, release_date = :#{#dao.getReleaseDate()} where id = :#{#id}")
    Mono<Integer> update(long id, AuthorDAO dao);
}
