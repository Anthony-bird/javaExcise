package com.company.spring5.test;

import com.company.spring5.entity.Book;
import com.company.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {

    @Test
    public void testJdbcTemplate() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //添加
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("java");
//        book.setUstatus("a");
//        bookService.addBook(book);

        //修改
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("javaup");
//        book.setUstatus("true");
//        bookService.updateBook(book);

        //bookService.deleteBook("1");

        //查询返回某个值
//        int count = bookService.findCount();
//        System.out.println(count);

        //查询返回对象
//        Book book = bookService.findOne("1");
//        System.out.println(book);

        //查询返回集合
//        List<Book> all = bookService.findAll();
//        System.out.println(all);

        //批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 ={"4","java","a"};
//        Object[] o2 ={"5","C++","b"};
//        Object[] o3 ={"6","MySQL","c"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//
//        bookService.batchAdd(batchArgs);

        //批量修改
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 ={"java452","a3","4"};
//        Object[] o2 ={"C++dgg","b4","5"};
//        Object[] o3 ={"MySQL46","c5","6"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//
//        bookService.batchUpdate(batchArgs);

        //批量删除
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 ={"4"};
        Object[] o2 ={"5"};

        batchArgs.add(o1);
        batchArgs.add(o2);


        bookService.batchDelete(batchArgs);
    }
}
