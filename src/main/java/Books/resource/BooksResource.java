package Books.resource;

import Books.model.Books;
import Books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
// URL added to primary portion. E.X. localhost:8080/books
@RequestMapping(value = "/books")
public class BooksResource {

    @Autowired
    BooksRepository bookRepository;


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/delete/1
    @GetMapping(value = "/delete/{bookId}")
    /**
     * Functions delete an entry from database depending on user specified id.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @Transactional
    public void delete(@PathVariable(value = "bookId") int bookId) throws SQLException {
        bookRepository.deleteByBookId(bookId);
    }//end delete


    // URL added to primary portion. E.X. localhost:8080/books/all
    @GetMapping(value = "/all")
    /**
     * Function querys the micro-service for all of the database.
     * @return List of all books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getAll() throws SQLException {
        return bookRepository.findAll();
    }//end getAll


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/title/Dresden Files
    @GetMapping(value = "/title/{title}")
    /**
     *  Function querys the micro-service for all entries with matching user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getByTitle(@PathVariable(value = "title") String title) throws SQLException  {
        return bookRepository.findByTitle(title);
    }//end getByTitle


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/authFName/Jim
    @GetMapping(value = "/authFName/{fname}")
    /**
     *  Function querys the micro-service for all entries with matching author first name from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getByFName(@PathVariable(value = "fname") String fname) throws SQLException  {
        return bookRepository.findByAuthFName(fname);
    }//end getByFName


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/authLName/Butcher
    @GetMapping(value = "/authLName/{lname}")
    /**
     *  Function querys the micro-service for all entries with matching author last name from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getByLName(@PathVariable(value = "lname") String lname) throws SQLException  {
        return bookRepository.findByAuthLName(lname);
    }//end getByLname


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/bookId/1
    @GetMapping(value = "/bookId/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getByBookId(@PathVariable(value = "id") int id)   {
        return bookRepository.findByBookId(id);
    }//end getByBookId


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/libId/1
    @GetMapping(value = "/libId/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getByLibId(@PathVariable(value = "id") int id) throws SQLException  {
        return bookRepository.findByLibId(id);
    }//end getByLibID


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/inOut/1
    @GetMapping(value = "/check/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Books> getByCheck(@PathVariable(value = "id") int id) throws SQLException  {
        return bookRepository.findByCheck(id);
    }//end getByCheck


    // URL added to primary portion. E.X. localhost:8080/members/insert
    @GetMapping(value = "/cho/{titleId}/{check}/{mid}")
    /**
     *  Function inserts new book object into database.
     *
     *  last modified by ricky.clevinger on 7/25/17
     */
    @Transactional
    public String checkout(@PathVariable(value = "titleId") int titleId,
                           @PathVariable(value = "mid") int mid,
                           @PathVariable(value = "check") int check) throws SQLException{
        Books b = bookRepository.findOne(titleId);
        Date date = new Date(System.currentTimeMillis() + (1000*60*60*24*7) );
        b.setCheck(check);
        b.setMid(mid);
        if (mid == 0){
            b.setOutDate(null);
        }
        else
            b.setOutDate(date);

        bookRepository.save(b);
        return "Success" + mid;
    }//end checkout


    // URL added to primary portion. E.X. localhost:8080/members/insert
    @GetMapping(value = "/insert/{title}/{authFName}/{authLName}/{libId}")
    /**
     *  Function inserts new book object into database.
     *
     *  last modified by ricky.clevinger on 7/25/17
     */
    public String insert(@PathVariable(value = "title") String title, @PathVariable(value = "authFName") String authFName,
                         @PathVariable(value = "authLName") String authLName, @PathVariable(value = "libId") int libId)
                            throws SQLException {
        Books temp = new Books(0,title, authFName, authLName, libId, 1, 0);
        bookRepository.save(temp);
        return "Success";
    }//end insert

    @ExceptionHandler({NumberFormatException.class, NullPointerException.class})
    public String nfeHandler(NumberFormatException e){
        return "Improper input";
    }

    public String npeHandler(NullPointerException e){
        return "Improper input";
    }


}
