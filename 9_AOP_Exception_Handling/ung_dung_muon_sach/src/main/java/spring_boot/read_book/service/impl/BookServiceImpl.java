package spring_boot.read_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot.read_book.model.Book;
import spring_boot.read_book.repository.IBookRepository;
import spring_boot.read_book.service.IBaseService;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements IBaseService<Book> {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            if (book.getQuantity() > 0) {
                book.setStatus(true);
            } else {
                book.setStatus(false);
            }
        }
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(String id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book.getQuantity() > 0) {
            book.setStatus(true);
        } else {
            book.setStatus(false);
        }
        return book;
    }
}
