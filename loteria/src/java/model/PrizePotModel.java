/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.PrizePot;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Joe
 */
public class PrizePotModel extends Model{

    public PrizePotModel() {
    }
    
    public List<Object>getAllPrizePot(){        
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(PrizePot.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createPrizePot(final PrizePot objPrizePot){        
        boolean insert = false;
        try {
            objPrizePot.setId(this.nextId(PrizePot.class));
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objPrizePot);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updatePrizePot(final PrizePot objPrizePot){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objPrizePot);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removePrizePot(final PrizePot objPrizePot){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objPrizePot);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public PrizePot getPrizePot(final BigDecimal id){
        PrizePot winner = null;
        
        try {
            winner = (PrizePot) this.executeQuery(new Callable<Object>() {
                @Override
                public PrizePot call() throws Exception {
                    return (PrizePot) session.get(PrizePot.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return winner;
    }
    
}
