package com.langchainexample.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookModel {

    private Integer id;

    private String title;

    @Description("Should be less than 20 words")
    private String description;

    private String genre;

    private LocalDate dateOfPublication;

    private String author;
}
