package com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.service.impl;

import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.jpa.Author;
import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.repository.AuthorRepository;
import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Author> findAllWithBooks() {
        return authorRepository.findAllWithBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
