package org.wcb.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wcb.Application;
import org.wcb.entity.Book;
import org.wcb.mapper.BookMapper;

/**
 * Created by wybe on 11/29/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestApp {

    @Autowired
    public BookMapper bookMapper;

    @Test
    public void insertTest() {
        Book book = new Book(114, "ccc", "cauthor", 12.88, 678, 890);
//        bookMapper.sellUpdate(11, 10);
//        bookMapper.delete(112);
//        book.setUsername("aaaa");
        bookMapper.insert(book);
//        List<Book> bookList = bookMapper.findByName("b");
//        book = bookMapper.findById(11);
//        System.out.println(bookList.get(0));
    }

    @Test
    public void testSearch() {
        Book book = bookMapper.findOne(113);
        Assert.assertEquals(book.getAuthor(), "ddd");
    }
}
