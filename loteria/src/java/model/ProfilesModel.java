/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Profiles;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class ProfilesModel extends Model {

    public ProfilesModel() {
    }
    
    public List<Object> getAllProfiles(){   
        List<Object> list = new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Profiles.class).list();
                }                
            });           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public void createProfiles(Profiles objProfiles){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objProfiles);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateProfiles(Profiles objProfiles){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objProfiles);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeProfiles(Profiles objProfiles){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objProfiles);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Profiles getProfiles(final BigDecimal id){
        Profiles profile = null;
        
        try {
            profile = (Profiles) this.executeQuery(new Callable<Object>() {
                @Override
                public Profiles call() throws Exception {
                    return (Profiles) session.get(Profiles.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return profile;
    }
    
}
