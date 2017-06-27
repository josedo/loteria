/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Recharges;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class RechargesModel {
    
    private Session session;

    public RechargesModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Recharges>getAllRecharges(){        
        List<Recharges> rechargesList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            rechargesList=session.createCriteria(Recharges.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return rechargesList;
    }
    
    public void createRecharges(Recharges objRecharges){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objRecharges);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateRecharges(Recharges objRecharges){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objRecharges);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeRecharges(Recharges objRecharges){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objRecharges);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Recharges getRecharges(int id){
        Recharges objRecharges=null;
        Transaction tx=session.beginTransaction();
        try{
            objRecharges=(Recharges)session.get(Recharges.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objRecharges;
    }
    
}
