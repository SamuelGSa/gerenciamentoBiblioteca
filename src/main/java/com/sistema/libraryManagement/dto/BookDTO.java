package com.sistema.libraryManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String publicationDate;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("numberOfPages")
    private int numberOfPages;

}
