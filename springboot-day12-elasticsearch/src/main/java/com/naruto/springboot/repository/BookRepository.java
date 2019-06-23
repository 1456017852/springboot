package com.naruto.springboot.repository;

import com.naruto.springboot.bean.Book;
import org.springframework.data.elasticsearch.repository.support.SimpleElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRepository extends SimpleElasticsearchRepository<Book> {


}
