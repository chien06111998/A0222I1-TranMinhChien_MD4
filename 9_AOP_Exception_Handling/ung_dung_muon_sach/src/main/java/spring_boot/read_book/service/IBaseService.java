package spring_boot.read_book.service;

import spring_boot.read_book.model.Book;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
    void add(T t);
    void delete(String id);
    void update(T t);
    Book findById(String id);
}
