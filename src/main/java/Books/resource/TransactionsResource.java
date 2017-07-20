package Books.resource;

import Books.model.Books;
import Books.model.Transaction;
import Books.repository.BooksRepository;
import Books.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
// URL added to primary portion. E.X. localhost:8080/books
@RequestMapping(value = "/trans")
public class TransactionsResource {

    @Autowired
    TransactionRepository transactionRepository;

    // URL added to primary portion. E.X. localhost:8080/books/all
    @GetMapping(value = "/all")
    /**
     *  Function querys the micro-service for all of the database.
     * @return List of all books from the micro-service.
     */
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    // URL added to primary portion. E.X. localhost:8080/load
    @PostMapping(value = "/load")
    public List<Transaction> persist(@RequestBody final Transaction transaction) {
        transactionRepository.save(transaction);
        return transactionRepository.findAll();
    }


    // URL added to primary portion. E.X. localhost:8080/members/insert
    @GetMapping(value = "/insert/{bookId}/{check}/{Mid}")
    /**
     *  Function inserts new book object into database.
     */
    @Transactional
    public String insert(@PathVariable(value = "bookId") int bookId, @PathVariable(value = "check") int check,
                         @PathVariable(value = "Mid") int Mid) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction temp = new Transaction(2,bookId, timestamp, check, Mid);
        transactionRepository.save(temp);
        return "Success";
    }


}
