package creemos.webrise.subs.rest;


import creemos.webrise.subs.entity.Subscription;
import creemos.webrise.subs.entity.User;
import creemos.webrise.subs.service.SubscriptionService;
import creemos.webrise.subs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("Пользователь создан!");
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
    ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Пользователь удален!");
    }

    //subs

    @PostMapping("/{id}/subscriptions")
    ResponseEntity<String> createSubscription(@PathVariable Integer id, @RequestBody Subscription subscription) {
        subscription.setUser(userService.getUser(id));
        subscriptionService.addSubscription(subscription);
        return ResponseEntity.ok("Подписка добавлена!");
    }

    @GetMapping("/{id}/subscriptions")
    List<Subscription> getUsersSubs(@PathVariable Integer id) {
        return subscriptionService.getUsersSubs(id);
    }

    // если НЕ использовать справочник подписок, то подразумевается передача первичного ключа из таблицы subscriptions,
    // в противном случае нужно искать по связке пользователь + тип подписки
    @DeleteMapping("/{id}/subscriptions/{sub_id}")
    ResponseEntity<String> deleteSubscription(@PathVariable Integer id, @PathVariable(name = "sub_id") Integer subId) {
        subscriptionService.deleteSubscription(subId);
        return ResponseEntity.ok("Подписка удалена!");
    }
}
