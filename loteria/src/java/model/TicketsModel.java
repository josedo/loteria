/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Tickets;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class TicketsModel {
    
    private Session session;

    public TicketsModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Tickets>getAllTickets(){        
        List<Tickets> ticketsList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            ticketsList=session.createCriteria(Tickets.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return ticketsList;
    }
    
    public void createTickets(Tickets objTickets){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objTickets);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateTickets(Tickets objTickets){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objTickets);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeTickets(Tickets objTickets){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objTickets);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Tickets getTickets(int id){
        Tickets objTickets=null;
        Transaction tx=session.beginTransaction();
        try{
            objTickets=(Tickets)session.get(Tickets.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objTickets;
    }
    
}
