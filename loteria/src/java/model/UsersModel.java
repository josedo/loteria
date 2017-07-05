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
    
    public List<Users> getAllUsers(){
        List<Users> list = new LinkedList<>();
        try{
            this.executeQueryList(new Callable<List<Object>>() {

                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Users.class).list();
                }
                                
            });           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
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
    
    public Users getUsers(final int id){
        Users user = null;
        
        try {
            user = (Users) this.executeQuery(new Callable<Object>() {

                @Override
                public Users call() throws Exception {
                    return (Users) session.get(Users.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return user;
    }
    
    public Users authenticate(final String username, final String password){
        Users user = null;
        try {
            user = (Users) this.executeQuery(new Callable<Object>() {

                @Override
                public Users call() throws Exception {
                    String hql = "From Users as user Where user.username = :userName and user.password = :passWord";
                    Query query = session.createQuery(hql);
                    query.setParameter("userName", username);
                    query.setParameter("passWord", password);
                    return (Users) query.uniqueResult();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
}
