package com.sistema.libraryManagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.libraryManagement.core.constants.ModelEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("actor")
    private String actor;

    @JsonProperty("isbn")
    private int isbn;

    @JsonProperty("publishingCompany")
    private String publishingCompany;

    @JsonProperty("publicationDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publicationDate;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("numberOfPages")
    private int numberOfPages;

    @JsonProperty("model")
    private ModelEnum model;

}
