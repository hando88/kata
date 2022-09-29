package spring.boot.dao;

import org.springframework.stereotype.Repository;
import spring.boot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entity;

    @Override
    public List<User> index() {
        return entity.createQuery("select c from User c", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entity.persist(user);
    }

    @Override
    public void delete(long id) {
        User user = entity.find(User.class, id);
        entity.remove(user);
    }

    @Override
    public User getUserById(long id) {
        return entity.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entity.merge(user);
    }
}
