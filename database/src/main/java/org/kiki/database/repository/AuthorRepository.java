package org.kiki.database.repository;

import org.kiki.database.dao.AuthorDAO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<AuthorDAO, Long> {
}
