package com.sistema.libraryManagement.persistence.entity;

import com.sistema.libraryManagement.core.constants.ModelEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "actor")
    private String actor;

    @Column(name = "isbn")
    private int isbn;

    @Column(name = "publishingCompany")
    private String publishingCompany;

    @Column(name = "publicationDate")
    private LocalDate publicationDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "numberOfPages")
    private int numberOfPages;

    @Column(name = "model")
    private ModelEnum model;

}
