package Books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
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


    public Book() {
    }

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
