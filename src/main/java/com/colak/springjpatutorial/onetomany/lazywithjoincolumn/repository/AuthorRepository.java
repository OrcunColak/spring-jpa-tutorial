package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.repository;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.jpa.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Avoid N+1 Query Problem
    // JOIN FETCH ensures that authors are retrieved along with their books in a single query.
    @Query("SELECT DISTINCT a FROM Author a JOIN FETCH a.books")
    List<Author> findAllWithBooks();
}
