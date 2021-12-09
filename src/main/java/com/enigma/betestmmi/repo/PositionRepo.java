package com.enigma.betestmmi.repo;

import com.enigma.betestmmi.config.HibernateConfiguration;
import com.enigma.betestmmi.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionRepo {
    private Session openSession() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        return sessionFactory.openSession();
    }
    public List<Position> getAllPosition(){
        Session session = openSession();

        session.beginTransaction();
        String hql = "FROM Position";
        List<Position> positions = session.createQuery(hql).getResultList();

        for (Position position:positions) {
            System.out.println(position);
        }
        session.close();
        return  positions;
    }

    public Position addPosition(Position position){
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        session.save(position);
        tx.commit();
        session.close();
        return position;
    }
    public void deletePositionById(Integer id){
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        Position position = getPositionById(id);
        session.delete(position);
        tx.commit();
        session.close();
        System.out.println("Position "+id+" is deleted");
    }
    public Position updatePosition(Position position){
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        session.update(position);
        tx.commit();

        session.close();

        return position;

    }
    public Position getPositionById(Integer id){
        openSession();
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        Position positions = session.get(Position.class, id);
        tx.commit();
        session.close();
        return positions;
    }
}
