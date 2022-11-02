package spring_boot.read_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.read_book.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, String> {
}
