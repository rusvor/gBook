package com.rusya.guestBook.dao;

import com.rusya.guestBook.entity.Guest;
import com.rusya.guestBook.util.HibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GuestDAOImpl implements GuestDAO {
    public int save(Guest guest) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        int saved = (Integer) session.save(guest);
        session.getTransaction().commit();
        return saved;

    }

  /*  public void udate(Guest guest) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(guest);
        session.getTransaction().commit();
    }*/

    public List<Guest> showAll() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Query query = session.createQuery("from Guest g");
        return query.list();
    }
}
