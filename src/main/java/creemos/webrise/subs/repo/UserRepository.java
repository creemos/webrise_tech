package creemos.webrise.subs.repo;


import creemos.webrise.subs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kay 07.05.2025
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    

}
