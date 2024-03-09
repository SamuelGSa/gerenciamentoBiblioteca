package com.sistema.libraryManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
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
    private String publicationDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "numberOfPages")
    private int numberOfPages;

}
