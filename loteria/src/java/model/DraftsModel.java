/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Drafts;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.Query;

/**
 *
 * @author Joe
 */
public class DraftsModel extends Model{

    public DraftsModel() {
    }
    
    public List<Object>getAllDrafts(){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Drafts.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createDrafts(final Drafts objDrafts){        
        boolean insert = false;
        try {
            BigDecimal id = this.nextId(Drafts.class);
            objDrafts.setId((id != null ? id : BigDecimal.ONE));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objDrafts);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateDrafts(final Drafts objDrafts){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objDrafts);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeDrafts(final Drafts objDrafts){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objDrafts);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Drafts getDrafts(final BigDecimal id){
        Drafts draft = null;
        
        try {
            draft = (Drafts) this.executeQuery(new Callable<Object>() {
                @Override
                public Drafts call() throws Exception {
                    return (Drafts) session.get(Drafts.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return draft;
    }
    
    public Drafts getPendingDrafts(){
        Drafts draft = null;
        try {
            final BigDecimal id = this.MaxId(Drafts.class);
            final Date date = Calendar.getInstance().getTime();
            final BigDecimal zero = BigDecimal.ZERO;
            draft = (Drafts) this.executeQuery(new Callable<Object>() {
                @Override
                public Drafts call() throws Exception {
                    String hql = "From Drafts as draft Where "
                            + "draft.id = :id and "
                            + "draft.date = :date and "
                            + "draft.number1 = :zero and "
                            + "draft.number2 = :zero and "
                            + "draft.number3 = :zero and "
                            + "draft.number4 = :zero and "
                            + "draft.number5 = :zero and "
                            + "draft.number6 = :zero";
                    Query query = session.createQuery(hql);
                    query.setParameter("id", id);
                    query.setParameter("date", date);
                    query.setParameter("zero", zero);
                    return (Drafts) session.get(Drafts.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return draft;
    }
    
    public Drafts getActualDrafts(){
        Drafts draft = null;
        try {
            final BigDecimal id = this.MaxId(Drafts.class);
            draft = (Drafts) this.executeQuery(new Callable<Object>() {
                @Override
                public Drafts call() throws Exception {
                    return (Drafts) session.get(Drafts.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return draft;
    }
    
}
