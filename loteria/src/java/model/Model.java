/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author jose.becerra
 */
public class Model {
    
    protected Session session;
    
    protected void setSession() {
        if (this.session == null || !this.session.isOpen())
            this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    protected Object executeQuery(Callable<Object> query) throws Exception {
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
    
    protected List<Object> executeQueryList(Callable<List<Object>> query) throws Exception {
        List<Object> list = new LinkedList<>();
        this.setSession();
        this.session.getTransaction().begin();
        try {
            list = query.call();
            this.session.getTransaction().commit();
        } catch(HibernateException ex) {
            ex.printStackTrace();
            this.session.getTransaction().rollback();
        }
        return list;
    }
    
    protected BigDecimal nextId(final Class entity) throws Exception {
        final String _class = entity.getSimpleName();
        return (BigDecimal) this.executeQuery(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                String hql = String.format("select MAX(ob.id) + 1 from %s ob", _class);
                Query query = session.createQuery(hql);
                return query.uniqueResult(); 
            }
        });
    }
}
