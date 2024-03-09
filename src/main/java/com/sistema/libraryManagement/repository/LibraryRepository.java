package com.sistema.libraryManagement.repository;

import com.sistema.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book,Integer> {

}
