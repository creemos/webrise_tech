package creemos.webrise.subs.rest;


import creemos.webrise.subs.model.TopSubscription;
import creemos.webrise.subs.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kay 07.05.2025
 */
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/top")
    List<TopSubscription> getTop() {
        return subscriptionService.getTop();
    }

}
