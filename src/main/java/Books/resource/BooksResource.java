package Books.resource;

import Books.model.Books;
import Books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    public List<Books> getAll() {
        return bookRepository.findAll();
    }

    // URL added to primary portion. E.X. localhost:8080/load
    @PostMapping(value = "/load")
    public List<Books> persist(@RequestBody final Books book) {
        bookRepository.save(book);
        return bookRepository.findAll();
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/title/Dresden Files
    @GetMapping(value = "/title/{title}")
    /**
     *  Function querys the micro-service for all entries with matching user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Books> getTitle(@PathVariable(value = "title") String title)  {
        return bookRepository.findByTitle(title);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/authFName/Jim
    @GetMapping(value = "/authFName/{fname}")
    /**
     *  Function querys the micro-service for all entries with matching author first name from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Books> getFName(@PathVariable(value = "fname") String fname)  {
        return bookRepository.findByAuthFName(fname);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/authLName/Butcher
    @GetMapping(value = "/authLName/{lname}")
    /**
     *  Function querys the micro-service for all entries with matching author last name from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Books> getLName(@PathVariable(value = "lname") String lname)  {
        return bookRepository.findByAuthLName(lname);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/bookId/1
    @GetMapping(value = "/bookId/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Books> getBookId(@PathVariable(value = "id") int id)  {
        return bookRepository.findByBookId(id);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/libId/1
    @GetMapping(value = "/libId/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Books> getLibId(@PathVariable(value = "id") int id)  {
        return bookRepository.findByLibId(id);
    }

    // URL added to primary portion. Also allows user input. E.X. localhost:8080/inOut/1
    @GetMapping(value = "/check/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     */
    public List<Books> getCheck(@PathVariable(value = "id") int id)  {
        return bookRepository.findByCheck(id);
    }



    // URL added to primary portion. E.X. localhost:8080/members/insert
    @GetMapping(value = "/cho/{titleId}/{check}/{mid}")
    /**
     *  Function inserts new book object into database.
     */
    @Transactional
    public String checkout(@PathVariable(value = "titleId") int titleId,
                           @PathVariable(value = "mid") int mid,
                           @PathVariable(value = "check") int check){
        Books b = bookRepository.findOne(titleId);
        b.setCheck(check);
        b.setMid(mid);

        bookRepository.save(b);
        return "Success" + mid;
    }






    // URL added to primary portion. Also allows user input. E.X. localhost:8080/delete/1
    @GetMapping(value = "/delete/{id}")
    /**
     *  Functions delete an entry from database depending on user specified id.
     * @return List of corresponding books from the micro-service.
     */
    @Transactional
    public String delete(@PathVariable(value = "id") int id)  {
        bookRepository.deleteByBookId(id);
        return "Success";
    }

    // URL added to primary portion. E.X. localhost:8080/members/insert
    @GetMapping(value = "/insert/{title}/{authFName}/{authLName}/{libId}")
    /**
     *  Function inserts new book object into database.
     */
    public String insert(@PathVariable(value = "title") String title, @PathVariable(value = "authFName") String authFName,
                         @PathVariable(value = "authLName") String authLName, @PathVariable(value = "libId") int libId) {
        Books temp = new Books(0,title, authFName, authLName, libId, 1, 0);
        bookRepository.save(temp);
        return "Success";
    }


}
