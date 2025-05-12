package creemos.webrise.subs.service;


import creemos.webrise.subs.entity.Subscription;
import creemos.webrise.subs.model.TopSubscription;
import creemos.webrise.subs.repo.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kay 07.05.2025
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<TopSubscription> getTop() {
        return subscriptionRepository.findTopSubscribes().stream()
                .map(o -> new TopSubscription((String) o[0], ((Number) o[1]).intValue()))
                .toList();
    }

    public void addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    public List<Subscription> getUsersSubs(Integer id) {
        return subscriptionRepository.getSubscriptionsByUser(id);
    }

    public void deleteSubscription(Integer id) {
        subscriptionRepository.deleteById(id);
    }

}
