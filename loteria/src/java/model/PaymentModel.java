/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Payment;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class PaymentModel {
    
    private Session session;

    public PaymentModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Payment>getAllPayment(){        
        List<Payment> paymentList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            paymentList=session.createCriteria(Payment.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return paymentList;
    }
    
    public void createPayment(Payment objPayment){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objPayment);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updatePayment(Payment objPayment){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objPayment);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removePayment(Payment objPayment){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objPayment);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Payment getPayment(int id){
        Payment objPayment=null;
        Transaction tx=session.beginTransaction();
        try{
            objPayment=(Payment)session.get(Payment.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objPayment;
    }
    
}
