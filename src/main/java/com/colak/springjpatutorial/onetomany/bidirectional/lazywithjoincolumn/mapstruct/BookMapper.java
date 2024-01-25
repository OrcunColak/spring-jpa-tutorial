package com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.mapstruct;

import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.dto.BookDTO;
import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.jpa.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToDTO(Book book);
}
