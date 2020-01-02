package io.devsecops.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.devsecops.api.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
