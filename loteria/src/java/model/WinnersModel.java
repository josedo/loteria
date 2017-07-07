/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Winners;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.Query;

/**
 *
 * @author Joe
 */
public class WinnersModel extends Model{

    public WinnersModel() {
    }
    
    public List<Object> getAllWinners(){
        List<Object> list = new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Winners.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createWinners(final Winners objWinners){        
        boolean insert = false;
        try {
            objWinners.setId(this.nextId(Winners.class));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objWinners);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateWinners(final Winners objWinners){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objWinners);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeWinners(final Winners objWinners){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objWinners);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Winners getWinners(final BigDecimal id){
        Winners winner = null;
        
        try {
            winner = (Winners) this.executeQuery(new Callable<Object>() {
                @Override
                public Winners call() throws Exception {
                    return (Winners) session.get(Winners.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return winner;
    }
    
    public List<Object> allByDraft(final BigDecimal draft){
        List<Object> list = new LinkedList<>();
        try {
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    String hql = "From Winners as w Where w.drafts_id = :maxId";
                    Query query = session.createQuery(hql);
                    query.setParameter("maxId", draft);
                    return query.list();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
