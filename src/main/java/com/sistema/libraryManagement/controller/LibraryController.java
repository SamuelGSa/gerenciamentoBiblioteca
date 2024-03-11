package com.sistema.libraryManagement.controller;

import com.sistema.libraryManagement.dto.BookDTO;
import com.sistema.libraryManagement.mapper.BookMapper;
import com.sistema.libraryManagement.model.Book;
import com.sistema.libraryManagement.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title) {

        List<Book> books = new ArrayList<>();

        books = libraryRepository.findAll();

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookDTO livro) {

        Book book = bookMapper.mapDTOToModel(livro);

        libraryRepository.save(book);

        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Integer id) {


        var requestedBook  = libraryRepository.findById(id);

        return new ResponseEntity<Optional<Book>>(requestedBook,HttpStatus.OK);
    }

}
