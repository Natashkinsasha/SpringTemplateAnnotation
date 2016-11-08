package by.natashkinsasha.springtemplateannotation.repository;


import by.natashkinsasha.springtemplateannotation.entity.User;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateUserRepository implements JpaRepository<User, Long> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User findOne(Long aLong) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, aLong);
        session.close();
        return user;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List list = session.createCriteria(User.class).list();
        session.close();
        return list;
    }

    @Override
    public List<User> findAll(Sort sort) {
        Session currentSession = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Session currentSession = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public List<User> findAll(Iterable<Long> iterable) {
        Session currentSession = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public <S extends User> List<S> save(Iterable<S> iterable) {
        Session currentSession = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public long count() {
        Session session = sessionFactory.openSession();

        return 0;
    }

    @Override
    public void delete(Long aLong) {
        Session session = sessionFactory.openSession();
        session.delete(aLong);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.delete(user);
    }

    @Override
    public void delete(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {
        Session session = sessionFactory.openSession();
        session.flush();
    }

    @Override
    public void deleteInBatch(Iterable<User> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Long aLong) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, aLong);
        session.close();
        return user;
    }

    @Override
    public User saveAndFlush(User s) {
        return null;
    }


}
