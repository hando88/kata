package org.example.dao;

import org.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entity;

    @Override
    @Transactional
    public List<User> index() {
        return entity.createQuery("select c from User c", User.class).getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        entity.persist(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        User user = entity.find(User.class, id);
        entity.remove(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return entity.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(User user) {
        entity.merge(user);
    }
}
