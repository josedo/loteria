/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Winners;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class WinnersModel {
    
    private Session session;

    public WinnersModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Winners>getAllWinners(){        
        List<Winners> winnersList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            winnersList=session.createCriteria(Winners.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return winnersList;
    }
    
    public void createWinners(Winners objWinners){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objWinners);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateWinners(Winners objWinners){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objWinners);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeWinners(Winners objWinners){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objWinners);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Winners getWinners(int id){
        Winners objWinners=null;
        Transaction tx=session.beginTransaction();
        try{
            objWinners=(Winners)session.get(Winners.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objWinners;
    }
    
}
