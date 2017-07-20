package Books.repository;

import Books.model.Books;
import Books.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    //Declaring functions
    //List<Transaction> findByBookIdOrderByTranDateDesc();

}
