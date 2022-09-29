package spring.boot.service;

import spring.boot.model.User;

import java.util.List;

public interface UserService {
    List<User> index();

    void save(User user);

    void delete(long id);

    User getUserById(long id);

    void update(User user);
}
