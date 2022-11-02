package spring_boot.read_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot.read_book.model.Book;
import spring_boot.read_book.model.Borrowing;
import spring_boot.read_book.repository.IBookRepository;
import spring_boot.read_book.repository.IBorrowingPepository;
import spring_boot.read_book.service.IBaseService;
import spring_boot.read_book.service.IBorrwingService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service("borrwingService")
public class BorrowingServiceImpl implements IBorrwingService {
    @Autowired
    IBorrowingPepository borrowingPepository;

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    IBaseService bookService;


    @Override
    public List<Borrowing> findAll() {
        return borrowingPepository.findAll();
    }

    @Override
    public void add(Borrowing borrowing, String idBook) {
        // nextInt random từ 0 đến 89999
        borrowing.setIdBorrow((new Random().nextInt(90000) + 10000) + "");
        Book book = bookService.findById(idBook);
        book.setQuantity(book.getQuantity() - 1);
        borrowing.setBook(book);
        borrowingPepository.save(borrowing);
    }

    @Override
    public void delete(int id) {
        Optional<Borrowing> borrowing = findByIdBorrow(id);
        Book book = bookService.findById(borrowing.get().getBook().getId());
        book.setQuantity(book.getQuantity()+1);
        borrowingPepository.delete(borrowing.get());
    }

    @Override
    public void update(Borrowing borrowing) {
        borrowingPepository.save(borrowing);
    }

    @Override
    public Optional<Borrowing> findByIdBorrow(int id) {
        return borrowingPepository.findById(id);
    }


}
