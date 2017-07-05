/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Users;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Joe
 */
public class UsersModel extends Model {
    

    public UsersModel() {
    }
    
    public List<Users>getAllUsers(){
        List<Users> usersList = new LinkedList<>();
        try{
            Transaction tx = session.beginTransaction();
            usersList = session.createCriteria(Users.class).list();
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return usersList;
    }
    
    public void createUsers(Users objUsers){        
        Transaction tx = session.beginTransaction();
        try{            
            session.save(objUsers);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateUsers(Users objUsers){        
        Transaction tx = session.beginTransaction();
        try{            
            session.update(objUsers);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeUsers(Users objUsers){        
        Transaction tx = session.beginTransaction();
        try{            
            session.delete(objUsers);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Users getUsers(int id){
        Users objUsers = null;
        Transaction tx = session.beginTransaction();
        try{
            objUsers = (Users) session.get(Users.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objUsers;
    }
    
    public Users authenticate(final String user, final String pass){
        Users objUsers = null;
        try {
            objUsers = (Users) this.exceuteQuery(new Callable<Object>() {

                @Override
                public Users call() throws Exception {
                    String hql = "From Users as user Where user.username = :userName and user.password = :passWord";
                    Query query = session.createQuery(hql);
                    query.setParameter("userName", user);
                    query.setParameter("passWord", pass);
                    return (Users) query.uniqueResult();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objUsers;
    }
    
}
