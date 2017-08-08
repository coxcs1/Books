package Books.repository;

import Books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {

    //Declaring functions
    String deleteByBookId(int bookId);
    List<Book> findByTitle(String title);
    List<Book> findByAuthFName(String name);
    List<Book> findByAuthLName(String name);
    List<Book> findByBookId(int id);
    List<Book> findByLibId(int id);
    List<Book> findByCheck(int id);
    List<Book> findByMid(int id);
    List<Book> findByCheckAndBookId(int check, int id);


}
