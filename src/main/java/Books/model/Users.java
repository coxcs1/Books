package Books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 * Object class used for querying database.
 */
public class Users {

    @Id
    @GeneratedValue
    // Declarations and column specifications. Make column names exact match to database.
    @Column(name = "Member_Id")
    private int id;
    @Column(name = "Member_FName")
    private String fname;
    @Column(name = "Member_LName")
    private String lname;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Role")
    private int role;

    public Users() {
    }

    /**
     * Constructor for Member
     * @param id
     * @param fname
     * @param lname
     */
    public Users(int id, String fname, String lname, String email, String password, int role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fname;
    }

    public void setFName(String name) {
        this.fname = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String name) {
        this.lname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
