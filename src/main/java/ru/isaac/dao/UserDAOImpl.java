package ru.isaac.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.isaac.model.User;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User saved successfully, User Details=" + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User updated successfully, User Details=" + user);
    }

    // TODO: 27.02.2017 заменить deprecated method 
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> usersList = criteria.list();
        for (User user : usersList) {
            logger.info("User List::" + user);
        }
        return usersList;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User loaded successfully, User details=" + user);
        return user;
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (null != user) {
            session.delete(user);
        }
        logger.info("User deleted successfully, User details=" + user);
    }

    // TODO: 02.03.2017 заменить deprecated method
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findByUsername(String username) {
        if (username == null || username.isEmpty()) {
            return listUsers();
        }
        else {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(User.class);
            List<User> usersList = criteria.add(Restrictions.like("username", username, MatchMode.START)).list();
            for (User user : usersList) {
                logger.info("User List::" + user);
            }
            return usersList;
        }
    }
}
