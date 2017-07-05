/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Users;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class UsersModel {
    
    private Session session;

    public UsersModel() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Users>getAllUsers(){        
        List<Users> usersList=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            usersList=session.createCriteria(Users.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return usersList;
    }
    
    public void createUsers(Users objUsers){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objUsers);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateUsers(Users objUsers){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objUsers);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeUsers(Users objUsers){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objUsers);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Users getUsers(int id){
        Users objUsers=null;
        Transaction tx=session.beginTransaction();
        try{
            objUsers=(Users)session.get(Users.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objUsers;
    }
    
    public Users authenticate(String user, String pass){
        Users objUsers=null;
        Transaction tx=session.beginTransaction();
        try{
            String hql="From Users as user Where user.USERNAME = :userName and user.PASSWORD = :passWord";
            Query query=this.session.createQuery(hql);
            query.setParameter("userName", user);
            query.setParameter("passWord", pass);
            objUsers=(Users)query.uniqueResult();
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objUsers;
    }
    
}
