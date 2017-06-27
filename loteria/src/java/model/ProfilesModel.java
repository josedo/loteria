/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Profiles;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class ProfilesModel {
    
    private Session session;

    public ProfilesModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Profiles>getAllProfiles(){        
        List<Profiles> profilesList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            profilesList=session.createCriteria(Profiles.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return profilesList;
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
    
    public Profiles getProfiles(int id){
        Profiles objProfiles=null;
        Transaction tx=session.beginTransaction();
        try{
            objProfiles=(Profiles)session.get(Profiles.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objProfiles;
    }
    
}
