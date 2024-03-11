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
    private Long isbn;

    @Column(name = "publishing_company")
    private String publishingCompany;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "numero_of_pages")
    private int numberOfPages;

    @Column(name = "model")
    private String model;

}
