package com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.mapstruct;

import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.dto.AuthorDTO;
import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.jpa.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (uses = BookMapper.class)
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToDTO(Author author);
}
