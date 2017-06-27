/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Pages;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class PagesModel {
    
    private Session session;

    public PagesModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Pages>getAllPages(){        
        List<Pages> pagesList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            pagesList=session.createCriteria(Pages.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return pagesList;
    }
    
    public void createPages(Pages objPages){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objPages);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updatePages(Pages objPages){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objPages);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removePages(Pages objPages){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objPages);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Pages getPages(int id){
        Pages objPages=null;
        Transaction tx=session.beginTransaction();
        try{
            objPages=(Pages)session.get(Pages.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objPages;
    }
    
}
