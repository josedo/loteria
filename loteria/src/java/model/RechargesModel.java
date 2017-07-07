/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Recharges;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Joe
 */
public class RechargesModel extends Model{

    public RechargesModel() {
    }
    
    public List<Object>getAllRecharges(){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Recharges.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createRecharges(final Recharges objRecharges){        
        boolean insert = false;
        try {
            BigDecimal id = this.nextId(Recharges.class);
            objRecharges.setId((id != null ? id : BigDecimal.ONE));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objRecharges);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateRecharges(final Recharges objRecharges){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objRecharges);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeRecharges(final Recharges objRecharges){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objRecharges);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Recharges getRecharges(final BigDecimal id){
        Recharges recharge = null;
        
        try {
            recharge = (Recharges) this.executeQuery(new Callable<Object>() {
                @Override
                public Recharges call() throws Exception {
                    return (Recharges) session.get(Recharges.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return recharge;
    }
    
}
