package com.sistema.libraryManagement.mapper;

import com.sistema.libraryManagement.dto.BookDTO;
import com.sistema.libraryManagement.model.Book;
import org.modelmapper.ModelMapper;

public class BookMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Book toEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public static BookDTO toDto(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }


}
