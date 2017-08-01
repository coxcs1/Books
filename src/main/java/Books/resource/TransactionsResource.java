package Books.resource;

import Books.model.Transaction;
import Books.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@RestController
// URL added to primary portion. E.X. localhost:8080/books
@RequestMapping(value = "/trans")
public class TransactionsResource {

    @Autowired
    TransactionRepository transactionRepository;

    /**
     * Function querys the micro-service for all of the database.
     * URL added to primary url.
     * @return List of all books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/23/17
     */
    @GetMapping(value = "/all")
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }//end getAll


    /**
     *  Function inserts new transaction object into database.
     *  URL added to primary url. Allows user input.
     *
     *  last modified by ricky.clevinger on 7/23/17
     */
    @GetMapping(value = "/insert/{bookId}/{check}/{Mid}")
    @Transactional
    public String insert(@PathVariable(value = "bookId") int bookId, @PathVariable(value = "check") int check,
                         @PathVariable(value = "Mid") int Mid) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction temp = new Transaction(2,bookId, timestamp, check, Mid);
        transactionRepository.save(temp);
        return "Success";
    }//end insert

}
