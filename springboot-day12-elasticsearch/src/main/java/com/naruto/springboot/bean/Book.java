package com.naruto.springboot.bean;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "naruto",type = "book")
public class Book {

    private Integer id;
    private  String bookName;
    private String author;
}
