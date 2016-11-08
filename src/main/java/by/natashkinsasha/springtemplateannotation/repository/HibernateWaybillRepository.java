package by.natashkinsasha.springtemplateannotation.repository;


import by.natashkinsasha.springtemplateannotation.entity.User;
import by.natashkinsasha.springtemplateannotation.entity.Waybill;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HibernateWaybillRepository implements JpaRepository<Waybill,Long>{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Waybill save(Waybill waybill) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(waybill);
        session.getTransaction().commit();
        session.close();
        return waybill;
    }

    @Override
    public Waybill findOne(Long aLong) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Waybill waybill = session.get(Waybill.class, aLong);
        waybill.getResponsiblePerson();
        waybill.getRegisteredBy();
        session.getTransaction().commit();
        session.close();
        return waybill;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<Waybill> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createCriteria(Waybill.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Waybill> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Waybill> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Waybill> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Waybill waybill) {

    }

    @Override
    public void delete(Iterable<? extends Waybill> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<Waybill> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Waybill getOne(Long aLong) {
        return null;
    }

    @Override
    public Waybill saveAndFlush(Waybill s) {
        return null;
    }

    @Override
    public <S extends Waybill> List<S> save(Iterable<S> iterable) {
        return null;
    }
}
