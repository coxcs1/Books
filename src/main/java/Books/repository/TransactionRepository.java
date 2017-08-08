package Books.repository;

import Books.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    //Declaring functions
    //List<Transaction> findByBookIdOrderByTranDateDesc();

}
