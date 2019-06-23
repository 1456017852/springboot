package com.naruto.springboot.bean;

import io.searchbox.annotations.JestId;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String context;
}
