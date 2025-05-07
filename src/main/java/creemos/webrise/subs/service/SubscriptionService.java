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
        Pageable top3 = PageRequest.of(0, 3);
        return subscriptionRepository.findTopSubscribes(top3);
    }

    public void addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

}
