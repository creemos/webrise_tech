package creemos.webrise.subs.service;


import creemos.webrise.subs.entity.User;
import creemos.webrise.subs.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kay 07.05.2025
 */
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id) {
        log.info("Получен id: {}", id);
        return userRepository.getReferenceById(id);
    }

    public void createUser(User user) {
        userRepository.save(user);
        log.info("Создан пользователь с id: {}", user.getId());
    }

    public User updateUser(Integer id, User user) {
        User old = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        old.setDescription(user.getDescription());
        old.setLogin(user.getLogin());
        log.info("Пользователь с id {} обновлён", old.getId());
        return userRepository.save(old);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
        log.info("Пользователь с id {} удалён", user.getId());
    }


}
