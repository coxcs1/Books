package Books.repository;

import Books.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

public interface MembersRepository extends JpaRepository<Member, Integer> {

    // Declaring functions
    List<Member> findByfname(String name);
    List<Member> findBylname(String name);
    List<Member> findById(int id);
    String deleteById(int id);

}
