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
public class Books {

    @Id
    @GeneratedValue
    // Declarations and column specifications. Make column names exact match to database.
    @Column(name = "Book_Id")
    private int bookId;
    @Column(name = "Book_Title")
    private String title;
    @Column(name = "Book_AuthFName")
    private String authFName;
    @Column(name = "Book_AuthLName")
    private String authLName;
    @Column(name = "Library_Id")
    private int libId;
    @Column (name = "Book_Check")
    private int check;
    @Column (name = "Mid")
    private int mid;
    @Column (name = "Book_Out_Date")
    private Date outDate;


    public Books() {
    }

    public Books(int bookId, String title, String authFName, String authLName, int libId, int check, int mid) {
        this.bookId = bookId;
        this.title = title;
        this.authFName = authFName;
        this.authLName = authLName;
        this.libId = libId;
        this.check = check;
        this.mid = mid;
    }

    // Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthFName() {
        return authFName;
    }

    public void setAuthFName(String fname) {
        this.authFName = fname;
    }

    public String getAuthLName() {
        return authLName;
    }

    public void setAuthLName(String lname) {
        this.authLName = lname;
    }

    public int getLibId() {
        return libId;
    }

    public void setLibId(int libId) {
        this.libId = libId;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
}
