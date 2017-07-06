/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Users;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.Query;

/**
 *
 * @author Joe
 */
public class UsersModel extends Model {
    

    public UsersModel() {
    }
    
    public List<Object> getAllUsers(){
        List<Object> list = new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
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
    
    public boolean createUsers(final Users objUsers){
        boolean insert = false;
        try {
            objUsers.setId(this.nextId(Users.class));
            insert = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.save(objUsers);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
    }
    
    public boolean updateUsers(final Users objUsers){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objUsers);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeUsers(final Users objUsers){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objUsers);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Users getUsers(final BigDecimal id){
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
