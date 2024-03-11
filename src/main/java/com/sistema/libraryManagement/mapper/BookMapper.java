package com.sistema.libraryManagement.mapper;

import com.sistema.libraryManagement.dto.BookDTO;
import com.sistema.libraryManagement.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Book mapDTOToModel(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }


}
