package Books.repository;

import Books.model.Books;
import Books.model.Transaction;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    //Declaring functions
    String deleteByBookId(int bookId);
    List<Books> findByTitle(String title);
    List<Books> findByAuthFName(String name);
    List<Books> findByAuthLName(String name);
    List<Books> findByBookId(int id);
    List<Books> findByLibId(int id);
    List<Books> findByCheck(int id);


}
