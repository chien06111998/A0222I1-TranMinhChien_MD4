package spring_boot.read_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.read_book.model.Borrowing;

@Repository
public interface IBorrowingPepository extends JpaRepository<Borrowing, Integer> {
}
