/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Profiles;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Joe
 */
public class ProfilesModel extends Model{

    public ProfilesModel() {
    }
    
    public List<Object>getAllProfiles(){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Profiles.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createProfiles(final Profiles objProfiles){        
        boolean insert = false;
        try {
            objProfiles.setId(this.nextId(Profiles.class));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objProfiles);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateProfiles(final Profiles objProfiles){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objProfiles);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeProfiles(final Profiles objProfiles){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.delete(objProfiles);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Profiles getProfiles(final BigDecimal id){
        Profiles profile = null;
        
        try {
            profile = (Profiles) this.executeQuery(new Callable<Object>() {
                @Override
                public Profiles call() throws Exception {
                    return (Profiles) session.get(Profiles.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return profile;
    }
    
}
