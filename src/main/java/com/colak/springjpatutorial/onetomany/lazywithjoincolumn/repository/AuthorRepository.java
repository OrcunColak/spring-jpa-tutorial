package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.repository;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.jpa.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Avoid N+1 Query Problem
    // JOIN FETCH ensures that authors are retrieved along with their books in a single query.
    @Query("SELECT DISTINCT a FROM Author a JOIN FETCH a.books")
    List<Author> findAllWithBooks();

    // Avoid N+1 Query Problem
    // select ... from author a1_0 left join book b1_0 on a1_0.id=b1_0.author_id where a1_0.id=?
    @EntityGraph(attributePaths = {"books"})
    @NonNull
    Optional<Author> findById(@NonNull Long id);
}
