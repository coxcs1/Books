package Books.repository;

import Books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {

    //Declaring functions
    List<Book> findByTitle(String title);
    List<Book> findByAuthFName(String name);
    List<Book> findByAuthLName(String name);
    List<Book> findByBookId(int id);
    List<Book> findByLibId(int id);
    String deleteById(int id);

}
