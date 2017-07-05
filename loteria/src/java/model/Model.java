/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.concurrent.Callable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jose.becerra
 */
public class Model {
    
    protected Session session;
    
    protected void setSession() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    protected Object exceuteQuery(Callable<Object> query) throws Exception {
        Object object = null;
        this.setSession();
        this.session.getTransaction().begin();
        try {
            object = query.call();
            this.session.getTransaction().commit();
        } catch(HibernateException ex) {
            ex.printStackTrace();
            this.session.getTransaction().rollback();
        }
        return object;
    }
}
