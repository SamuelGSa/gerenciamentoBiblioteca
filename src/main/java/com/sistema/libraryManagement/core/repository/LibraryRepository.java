package com.sistema.libraryManagement.core.repository;

import com.sistema.libraryManagement.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book,Integer> {

}
