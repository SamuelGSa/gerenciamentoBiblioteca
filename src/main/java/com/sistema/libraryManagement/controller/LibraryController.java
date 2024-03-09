package com.sistema.libraryManagement.controller;

import com.sistema.libraryManagement.model.Book;
import com.sistema.libraryManagement.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title) {

        List<Book> books = new ArrayList<>();

        books = libraryRepository.findAll();

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book livro) {

        libraryRepository.save(livro);

        return new ResponseEntity<>(livro,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Integer id) {


        var requestedBook  = libraryRepository.findById(id);

        return new ResponseEntity<Optional<Book>>(requestedBook,HttpStatus.OK);
    }

}
