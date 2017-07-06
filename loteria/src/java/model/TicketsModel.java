/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Tickets;
import entities.Users;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.Query;

/**
 *
 * @author Joe
 */
public class TicketsModel extends Model{

    public TicketsModel() {
    }
    
    public List<Object>getAllTickets(){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Tickets.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createTickets(final Tickets objTickets){        
        boolean insert = false;
        try {
            objTickets.setId(this.nextId(Tickets.class));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objTickets);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateTickets(final Tickets objTickets){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objTickets);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeTickets(final Tickets objTickets){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objTickets);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Tickets getTickets(final BigDecimal id){
        Tickets user = null;
        
        try {
            user = (Tickets) this.executeQuery(new Callable<Object>() {
                @Override
                public Tickets call() throws Exception {
                    return (Tickets) session.get(Tickets.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return user;
    }
    
    public Tickets getByUser(final Users user){
        Tickets ticket = null;
        try {
            ticket = (Tickets) this.executeQuery(new Callable<Object>() {
                @Override
                public Tickets call() throws Exception {
                    String hql = "From Tickets as ticket Where ticket.users = :user";
                    Query query = session.createQuery(hql);
                    query.setParameter("user", user);
                    return (Tickets) query.uniqueResult();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ticket;
    }
    
}
