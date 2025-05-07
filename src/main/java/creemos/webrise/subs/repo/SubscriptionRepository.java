package creemos.webrise.subs.repo;


import creemos.webrise.subs.entity.Subscription;
import creemos.webrise.subs.model.TopSubscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kay 07.05.2025
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Query("SELECT new creemos.webrise.subs.model.TopSubscription(s.text, COUNT(s)) AS count FROM Subscription s GROUP BY s.text ORDER BY count DESC")
    List<TopSubscription> findTopSubscribes(Pageable pageable);

    @Query("SELECT s FROM Subscription s WHERE s.user.id = :id")
    List<Subscription> getSubscriptionsByUser(Integer id);

}
