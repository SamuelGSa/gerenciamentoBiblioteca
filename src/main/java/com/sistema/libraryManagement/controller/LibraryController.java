package com.sistema.libraryManagement.controller;

import com.sistema.libraryManagement.dto.BookDTO;
import com.sistema.libraryManagement.core.mapper.BookMapper;
import com.sistema.libraryManagement.persistence.entity.Book;
import com.sistema.libraryManagement.core.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
@Validated
@Slf4j
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;

    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> books = new ArrayList<>();

        books = libraryRepository.findAll();

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook( @RequestBody BookDTO livro) {

        Book book = bookMapper.mapDTOToModel(livro);

        libraryRepository.save(book);

        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Integer id) {

        var requestedBook  = libraryRepository.findById(id);

        return new ResponseEntity<>(requestedBook,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Book>> deleteBookById(@PathVariable Integer id) {
        try {
            libraryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Integer id, @RequestBody BookDTO newBook) {

        return libraryRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setActor(newBook.getActor());
                    book.setIsbn(newBook.getIsbn());
                    book.setPublishingCompany(newBook.getPublishingCompany());
                    book.setPublicationDate(newBook.getPublicationDate());
                    book.setGender(newBook.getGender());
                    book.setNumberOfPages(newBook.getNumberOfPages());
                    book.setModel(newBook.getModel().name());
                    Book bookUpdated = libraryRepository.save(book);
                    return ResponseEntity.ok().body(bookUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
