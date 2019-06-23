package com.naruto.springboot;

import com.naruto.springboot.bean.Article;
import com.naruto.springboot.bean.Book;
import com.naruto.springboot.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 测试创建索引
     */
    @Test
    public void testCreat() {
        //创建文章对象
        Article article=new Article(1,"naruto","好消息","hello world");
        //创建索引
        Index index=new Index.Builder(article).index("naruto").type("news").build();
        try{
            jestClient.execute(index);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 测试查询索引
     */
    @Test
    public void testSearch(){
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"context\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //创建搜索对象
        Search search=new Search.Builder(json).addIndex("naruto").addType("news").build();
        try {
            //
            SearchResult searchResult=jestClient.execute(search);
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testElasticSearch(){
        bookRepository.index(new Book(1,"西游记","吴承恩"));
    }

}
