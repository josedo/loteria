/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Drafts;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class DraftsModel {
    
    private Session session;

    public DraftsModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Drafts>getAllDrafts(){        
        List<Drafts> draftsList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            draftsList=session.createCriteria(Drafts.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return draftsList;
    }
    
    public void createDrafts(Drafts objDrafts){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objDrafts);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateDrafts(Drafts objDrafts){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objDrafts);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeDrafts(Drafts objDrafts){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objDrafts);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Drafts getDrafts(int id){
        Drafts objDrafts=null;
        Transaction tx=session.beginTransaction();
        try{
            objDrafts=(Drafts)session.get(Drafts.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objDrafts;
    }
    
}
