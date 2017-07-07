/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Drafts;
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
    
    public List<Object> getAllTickets(){
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
            BigDecimal id = this.nextId(Tickets.class);
            objTickets.setId((id != null ? id : BigDecimal.ONE));
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
    
    public List<Object> getByUser(final Users user, final Drafts draft){
        List<Object> list = new LinkedList<>();
        try {
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    String hql = "From Tickets as ticket Where ticket.users = :user and ticket.drafts = :draft ";
                    Query query = session.createQuery(hql);
                    query.setParameter("user", user);
                    query.setParameter("draft", draft);
                    return query.list();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<Object> allByDraft(final Drafts draft){
        List<Object> list = new LinkedList<>();
        try {
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    String hql = "From Tickets as ticket Where ticket.drafts = :draft ";
                    Query query = session.createQuery(hql);
                    query.setParameter("draft", draft);
                    return query.list();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<Object> allByUser(final Users user){
        List<Object> list = new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    String hql = "From Tickets as ticket Where ticket.users = :user";
                    Query query = session.createQuery(hql);
                    query.setParameter("user", user);
                    return query.list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
        
    }
    
    public boolean checkTicket(final Tickets ticket){
        Tickets t = null;
        try {
            t = (Tickets) this.executeQuery(new Callable<Object>() {
                @Override
                public Tickets call() throws Exception {
                    String hql = "From Tickets as ticket Where "
                            + "ticket.number1 = :number1 and "
                            + "ticket.number2 = :number2 and "
                            + "ticket.number3 = :number3 and "
                            + "ticket.number4 = :number4 and "
                            + "ticket.number5 = :number5 and "
                            + "ticket.number6 = :number6 and "
                            + "ticket.drafts = :draft ";
                    Query query = session.createQuery(hql);
                    query.setParameter("number1", ticket.getNumber1());
                    query.setParameter("number2", ticket.getNumber2());
                    query.setParameter("number3", ticket.getNumber3());
                    query.setParameter("number4", ticket.getNumber4());
                    query.setParameter("number5", ticket.getNumber5());
                    query.setParameter("number6", ticket.getNumber6());
                    query.setParameter("draft", ticket.getDrafts());
                    return (Tickets) query.uniqueResult();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return t == null;
    }
    
}
