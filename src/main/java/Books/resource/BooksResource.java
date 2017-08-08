package Books.resource;

import Books.model.Book;
import Books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
// URL added to primary portion. E.X. localhost:8080/books
@RequestMapping(value = "/books")
public class BooksResource {

    @Autowired
    BooksRepository bookRepository;

    /**
     * Functions delete an entry from database depending on user specified id.
     * URL added to primary url. Allows user input.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/delete/{bookId}")
    @Transactional
    public void delete(@PathVariable(value = "bookId") int bookId) throws SQLException {
        bookRepository.deleteByBookId(bookId);
    }//end delete


    /**
     * Function querys the micro-service for all of the database.
     * URL added to primary url. Allows user input.
     * @return List of all books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/all")
    public List<Book> getAll() throws SQLException {
        return bookRepository.findAll();
    }//end getAll


    /**
     * Function querys the micro-service for all entries with matching user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/title/{title}")
    public List<Book> getByTitle(@PathVariable(value = "title") String title) throws SQLException  {
        return bookRepository.findByTitle(title);
    }//end getByTitle


    /**
     * Function querys the micro-service for all entries with matching author first name from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/authFName/{fname}")
    public List<Book> getByFName(@PathVariable(value = "fname") String fname) throws SQLException  {
        return bookRepository.findByAuthFName(fname);
    }//end getByFName


    /**
     * Function querys the micro-service for all entries with matching author last name from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/authLName/{lname}")
    public List<Book> getByLName(@PathVariable(value = "lname") String lname) throws SQLException  {
        return bookRepository.findByAuthLName(lname);
    }//end getByLname


    /**
     * Functions querys the micro-service for all entries with matching id from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/bookId/{id}")
    public List<Book> getByBookId(@PathVariable(value = "id") int id)   {
        return bookRepository.findByBookId(id);
    }//end getByBookId


    /**
     * Functions querys the micro-service for all entries with matching id from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/libId/{id}")
    public List<Book> getByLibId(@PathVariable(value = "id") int id) throws SQLException  {
        return bookRepository.findByLibId(id);
    }//end getByLibID


    /**
     * Functions querys the micro-service for all entries with matching id from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/check/{id}")
    public List<Book> getByCheck(@PathVariable(value = "id") int id) throws SQLException  {
        return bookRepository.findByCheck(id);
    }//end getByCheck

    /**
     * Functions querys the micro-service for all entries with matching id from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 8/3/17
     */
    @GetMapping(value = "/mid/{id}")
    public List<Book> getByMid(@PathVariable(value = "id") int id) throws SQLException  {
        return bookRepository.findByMid(id);
    }//end getByCheck

    /**
     * Functions querys the micro-service for all entries with matching id from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/checkAndId/{check}/{id}")
    public List<Book> getByCheckAndBookId(@PathVariable(value = "check") int check,
                                           @PathVariable(value = "id") int id) throws SQLException  {
        return bookRepository.findByCheckAndBookId(check,id);
    }//end getByCheckAndBookId


    /**
     *  Function inserts new book object into database.
     *  URL added to primary url. Allows user input.
     *
     *  last modified by ricky.clevinger on 7/25/17
     */
    @GetMapping(value = "/cho/{titleId}/{check}/{mid}")
    @Transactional
    public String checkout(@PathVariable(value = "titleId") int titleId,
                           @PathVariable(value = "mid") int mid,
                           @PathVariable(value = "check") int check) throws SQLException{
        Book b = bookRepository.findOne(titleId);
        Date date = new Date(System.currentTimeMillis() );
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


    /**
     *  Function inserts new book object into database.
     *  URL added to primary url. Allows user input.
     *
     *  last modified by ricky.clevinger on 7/25/17
     */
    @GetMapping(value = "/insert/{title}/{authFName}/{authLName}/{libId}")
    public String insert(@PathVariable(value = "title") String title, @PathVariable(value = "authFName") String authFName,
                         @PathVariable(value = "authLName") String authLName, @PathVariable(value = "libId") int libId)
                            throws SQLException {
        Book temp = new Book(0,title, authFName, authLName, libId, 1, 0);
        bookRepository.save(temp);
        return "Success";
    }//end insert

    @ExceptionHandler({NumberFormatException.class, NullPointerException.class})
    @SuppressWarnings("unused")
    public String nfeHandler(NumberFormatException e){
        return "Improper input";
    }

    @SuppressWarnings("unused")
    public String npeHandler(NullPointerException e){
        return "Improper input";
    }


}
