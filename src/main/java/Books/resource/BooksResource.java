package Books.resource;

import Books.model.Book;
import Books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksResource {

    @Autowired
    BooksRepository bookRepository;

    @GetMapping(value = "/all")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }


    @PostMapping(value = "/load")
    public List<Book> persist(@RequestBody final Book book) {
        bookRepository.save(book);
        return bookRepository.findAll();
    }

    @GetMapping(value = "/title/{title}")
    public List<Book> getTitle(@PathVariable(value = "title") String title)  {
        return bookRepository.findByTitle(title);
    }

    @GetMapping(value = "/authFName/{fname}")
    public List<Book> getFName(@PathVariable(value = "fname") String fname)  {
        return bookRepository.findByAuthFName(fname);
    }

    @GetMapping(value = "/authLName/{lname}")
    public List<Book> getLName(@PathVariable(value = "lname") String lname)  {
        return bookRepository.findByAuthLName(lname);
    }

    @GetMapping(value = "/bookId/{id}")
    public List<Book> getBookId(@PathVariable(value = "id") int id)  {
        return bookRepository.findByBookId(id);
    }

    @GetMapping(value = "/libId/{id}")
    public List<Book> getLibId(@PathVariable(value = "id") int id)  {
        return bookRepository.findByLibId(id);
    }

}
