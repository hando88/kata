package spring.boot.dao;

import spring.boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    void save(User user);

    void delete(long id);

    User getUserById(long id);

    void update(User user);
}
