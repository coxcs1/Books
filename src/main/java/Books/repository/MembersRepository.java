package Books.repository;

import Books.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembersRepository extends JpaRepository<Member, Integer> {

    // Declaring functions
    List<Member> findByfname(String name);
    List<Member> findBylname(String name);
    List<Member> findById(int id);
    String deleteById(int id);



}
