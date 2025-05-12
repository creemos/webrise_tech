package creemos.webrise.subs.repo;


import creemos.webrise.subs.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kay 07.05.2025
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Query("SELECT s.text, COUNT(s) FROM Subscription s GROUP BY s.text ORDER BY COUNT(s) DESC LIMIT 3")
    List<Object[]> findTopSubscribes();

    @Query("SELECT s FROM Subscription s WHERE s.user.id = :id")
    List<Subscription> getSubscriptionsByUser(Integer id);

}
