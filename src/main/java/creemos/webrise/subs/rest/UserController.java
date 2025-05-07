package creemos.webrise.subs.rest;


import creemos.webrise.subs.entity.Subscription;
import creemos.webrise.subs.entity.User;
import creemos.webrise.subs.service.SubscriptionService;
import creemos.webrise.subs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author kay 06.05.2025
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionService subscriptionService;

    // users

    @PostMapping
    void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable Integer id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        User user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }

    //subs

    @PostMapping("/{id}/subscriptions")
    void createSubscribe(@PathVariable Integer id, @RequestBody Subscription subscription) {
        subscription.setUser(userService.getUser(id));
        subscriptionService.addSubscription(subscription);
    }


}
