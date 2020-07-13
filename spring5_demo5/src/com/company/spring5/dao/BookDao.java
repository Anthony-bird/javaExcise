package com.company.spring5.dao;

import com.company.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    //添加的方法
    void add(Book book);

    //修改的方法
    void updataBook(Book book);

    //删除的方法
    void delete(String id);

    //查询表的记录
    int selectCount();

    //查询返回对象
    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    //批量修改
    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
