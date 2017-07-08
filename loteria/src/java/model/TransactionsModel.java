/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Tickets;
import entities.Transactions;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Joe
 */
public class TransactionsModel extends Model{

    public TransactionsModel() {
    }
    
    public List<Object> getAllTransactions(){
        List<Object> list=new LinkedList<>();
        try{
            list = this.executeQueryList(new Callable<List<Object>>() {
                @Override
                public List<Object> call() throws Exception {
                    return session.createCriteria(Transactions.class).list();
                }
            }); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean createTransactions(final Transactions objTransactions){        
        boolean insert = false;
        try {
            this.executeQuery(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return session.save(objTransactions);
                }
            });
            insert = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insert;
        
    }
    
    public boolean updateTransactions(final Transactions objTransactions){
        boolean update = false;
        try {
            update = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objTransactions);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }
    
    public boolean removeTransactions(final Transactions objTransactions){
        boolean delete = false;
        try {
            delete = (Boolean) this.executeQuery(new Callable<Object>() {
                @Override
                public Boolean call() throws Exception {
                    session.update(objTransactions);
                    return true;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return delete;
        
    }
    
    public Transactions getTransactions(final BigDecimal id){
        Transactions transactions = null;
        
        try {
            transactions = (Transactions) this.executeQuery(new Callable<Object>() {
                @Override
                public Tickets call() throws Exception {
                    return (Tickets) session.get(Transactions.class, id);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return transactions;
    }
    
}
