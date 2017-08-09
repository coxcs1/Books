package Books.resource;

import Books.model.Users;
import Books.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// URL added to primary portion. E.X. localhost:8080/members
@RequestMapping(value = "/members")
@RestController
public class UsersResource {

    @Autowired
    UsersRepository memRepository;

    /**
     * Function querys the micro-service for all of the database.
     * URL added to primary url. Allows user input.
     * @return List of all members from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return memRepository.findAll();
    }//end getAll


    /**
     * Function querys the micro-service for all entries with matching first name from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/fname/{fname}")
    public List<Users> getByFName(@PathVariable(value = "fname") String fname)  {
        return memRepository.findByfname(fname);
    }//end getByFName


    /**
     * Function querys the micro-service for all entries with matching last name from user input.
     * URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/lname/{lname}")
    public List<Users> getByLName(@PathVariable(value = "lname") String lname)  {
        return memRepository.findBylname(lname);
    }//end getByLName


    /**
     *  Functions querys the micro-service for all entries with matching id from user input.
     *  URL added to primary url. Allows user input.
     * @return List of corresponding books from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/id/{id}")
    public List<Users> getById(@PathVariable(value = "id") int id)  {
        return memRepository.findById(id);
    }//end getById


    /**
     *  Function inserts new Member Object into database.
     *  URL added to primary url. Allows user input.
     *
     *  last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/insert/{fname}/{lname}/{email}/{password}/{role}")
    public String insert(@PathVariable(value = "fname") String fname, @PathVariable(value = "lname") String lname,
                         @PathVariable(value = "email") String email, @PathVariable(value = "password") String password,
                         @PathVariable(value = "role") int role) {
        Users temp = new Users(0,fname, lname,email,password, role);
        memRepository.save(temp);
        return "Success";
    }//end insert


    /**
     *  Function deletes entry from database depending on user input id.
     *  URL added to primary url. Allows user input.
     *
     *  last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/delete/{id}")
    @Transactional
    public String delete(@PathVariable(value = "id") int id) {
        memRepository.deleteById(id);
        return "Success";
    }//end delete


    /**
     *  Functions querys the micro-service for all entries with matching info from user input.
     *  URL added to primary url. Allows user input.
     * @return List of corresponding members from the micro-service.
     *
     * last modified by ricky.clevinger on 7/21/17
     */
    @GetMapping(value = "/login/{email}/{password}")
    public List<Users> getByEmailAndPassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password)  {
        return memRepository.findByEmailAndPassword(email,password);
    }//end getByEmailAndPassword

}
