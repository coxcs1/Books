package Books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 * Object class used for querying database.
 */
public class Book {

    @Id
    @GeneratedValue
    // Declarations and coulmn specifications. Make column names exact match to database.
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
}
