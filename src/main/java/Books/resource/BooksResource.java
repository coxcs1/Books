package Books.resource;

import Books.model.Book;
import Books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// URL added to primary portion. E.X. localhost:8080/books
@RequestMapping(value = "/books")
public class BooksResource {

    @Autowired
    BooksRepository bookRepository;

    // URL added to primary portion. E.X. localhost:8080/books/all
    @GetMapping(value = "/all")
    /**
     *  Function querys the micro-service for all of the database.
     * @return List of all books from the micro-service.
     */
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // URL added to primary portion. E.X. localhost:8080/load
    @PostMapping(value = "/load")
    public List<Book> persist(@RequestBody final Book book) {
        bookRepository.save(book);
        return bookRepository.findAll();
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/title/Dresden Files
    @GetMapping(value = "/title/{title}")
    /**
     *  Function querys the micro-service for all entries with matching user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Book> getTitle(@PathVariable(value = "title") String title)  {
        return bookRepository.findByTitle(title);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/authFName/Jim
    @GetMapping(value = "/authFName/{fname}")
    /**
     *  Function querys the micro-service for all entries with matching author first name from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Book> getFName(@PathVariable(value = "fname") String fname)  {
        return bookRepository.findByAuthFName(fname);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/authLName/Butcher
    @GetMapping(value = "/authLName/{lname}")
    /**
     *  Function querys the micro-service for all entries with matching author last name from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Book> getLName(@PathVariable(value = "lname") String lname)  {
        return bookRepository.findByAuthLName(lname);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/bookId/1
    @GetMapping(value = "/bookId/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Book> getBookId(@PathVariable(value = "id") int id)  {
        return bookRepository.findByBookId(id);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/libId/1
    @GetMapping(value = "/libId/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Book> getLibId(@PathVariable(value = "id") int id)  {
        return bookRepository.findByLibId(id);
    }

}
