package Books.repository;

import Books.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    // Declaring functions
    List<Users> findByfname(String name);
    List<Users> findBylname(String name);
    List<Users> findById(int id);
    List<Users> findByEmailAndPassword(String email,String password);
    String deleteById(int id);

}
