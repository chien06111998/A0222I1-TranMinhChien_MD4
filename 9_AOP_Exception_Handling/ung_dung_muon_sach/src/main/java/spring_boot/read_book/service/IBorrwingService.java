package spring_boot.read_book.service;

import spring_boot.read_book.model.Borrowing;

import java.util.List;
import java.util.Optional;

public interface IBorrwingService {
    List<Borrowing> findAll();
    void add(Borrowing borrowing, String idBook);
    void delete(int id);
    void update(Borrowing borrowing);
    Optional<Borrowing> findByIdBorrow(int id);
}
