/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.ProfilesPages;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.Query;

/**
 *
 * @author Joe
 */
public class ProfilesPagesModel extends Model{

    public ProfilesPagesModel() {
    }
    
    public List<Object>getAllProfiles(){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(ProfilesPages.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
        public List<Object>getAllProfilesPagesByProfile(final BigDecimal id){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    String hql = "select p From Pages as p join p.profilesPageses as pp Where p.id = pp.pages.id and pp.profiles.id = :id";
                    Query query = session.createQuery(hql);
                    query.setParameter("id", id);
                    return query.list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createProfiles(final ProfilesPages objProfilesPages){        
        boolean insert = false;
        try {
            BigDecimal id = this.nextId(ProfilesPages.class);
            objProfilesPages.setId((id != null ? id : BigDecimal.ONE));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objProfilesPages);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateProfilesPages(final ProfilesPages objProfilesPages){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objProfilesPages);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeProfilesPages(final ProfilesPages objProfilesPages){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.delete(objProfilesPages);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public ProfilesPages getProfilesPages(final BigDecimal id){
        ProfilesPages profilesPages = null;
        
        try {
            profilesPages = (ProfilesPages) this.executeQuery(new Callable<Object>() {
                @Override
                public ProfilesPages call() throws Exception {
                    return (ProfilesPages) session.get(ProfilesPages.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return profilesPages;
    }
    
}
