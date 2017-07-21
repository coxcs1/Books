package Books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 * Object class used for querying database.
 */
public class Member {

    @Id
    @GeneratedValue
    // Declarations and column specifications. Make column names exact match to database.
    @Column(name = "Member_Id")
    private int id;
    @Column(name = "Member_FName")
    private String fname;
    @Column(name = "Member_LName")
    private String lname;

    public Member() {
    }

    /**
     * Constructor for Member
     * @param id
     * @param fname
     * @param lname
     */
    public Member(int id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
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

}
