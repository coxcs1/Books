package Books.resource;

import Books.model.Member;
import Books.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// URL added to primary portion. E.X. localhost:8080/members
@RequestMapping(value = "/members")
public class MembersResource {

    @Autowired
    MembersRepository memRepository;

    // URL added to primary portion. E.X. localhost:8080/members/all
    @GetMapping(value = "/all")
    /**
     *  Function querys the micro-service for all of the database.
     * @return List of all members from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Member> getAll() {
        return memRepository.findAll();
    }//end getAll


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/fname/Ricky
    @GetMapping(value = "/fname/{fname}")
    /**
     *  Function querys the micro-service for all entries with matching first name from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Member> getByFName(@PathVariable(value = "fname") String fname)  {
        return memRepository.findByfname(fname);
    }//end getByFName


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/lname/Coalson
    @GetMapping(value = "/lname/{lname}")
    /**
     *  Function querys the micro-service for all entries with matching last name from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Member> getByLName(@PathVariable(value = "lname") String lname)  {
        return memRepository.findBylname(lname);
    }//end getByLName


    // URL added to primary portion. Also allows user input. E.X. localhost:8080/id/1
    @GetMapping(value = "/id/{id}")
    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    public List<Member> getById(@PathVariable(value = "id") int id)  {
        return memRepository.findById(id);
    }//end getById


    // URL added to primary portion. E.X. localhost:8080/members/insert
    @GetMapping(value = "/insert/{fname}/{lname}")
    /**
     *  Function inserts new Member Object into database.
     *
     *  last modified by ricky.clevinger on 7/21/17
     */
    public String insert(@PathVariable(value = "fname") String fname, @PathVariable(value = "lname") String lname) {
        Member temp = new Member(0,fname, lname);
        memRepository.save(temp);
        return "Success";
    }//end insert


    // URL added to primary portion. E.X. localhost:8080/members/delete
    @GetMapping(value = "/delete/{id}")
    /**
     *  Function deletes entry from database depending on user input id.
     *
     *  last modified by ricky.clevinger on 7/21/17
     */
    @Transactional
    public String delete(@PathVariable(value = "id") int id) {
        memRepository.deleteById(id);
        return "Success";
    }//end delete

}
