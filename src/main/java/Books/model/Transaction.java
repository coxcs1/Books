package Books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
/**
 * Object class used for querying database.
 */
public class Transaction {

    @Id
    @GeneratedValue
    // Declarations and column specifications. Make column names exact match to database.
    @Column(name = "Transaction")
    private int tran;
    @Column(name = "Book_Id")
    private int bookId;
    @Column(name = "Tran_Date")
    private Timestamp tDate;
    @Column(name = "Che")
    private int check;
    @Column(name = "Mid")
    private int Mid;


    public Transaction() {
    }

    public Transaction(int tran, int bookId, Timestamp tDate, int check, int Mid) {
        this.tran = tran;
        this.bookId = bookId;
        this.tDate = tDate;
        this.check = check;
        this.Mid = Mid;
    }

    // Getters and Setters


    public int getTran() {
        return tran;
    }

    public void setTran(int tran) {
        this.tran = tran;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Timestamp getTDate() {
        return tDate;
    }

    public void setTDate(Timestamp tDate) {
        this.tDate = tDate;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getMid() {
        return Mid;
    }

    public void setMid(int Mid) {
        this.Mid = Mid;
    }
}
