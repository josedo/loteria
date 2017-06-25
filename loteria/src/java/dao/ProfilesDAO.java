/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;

/**
 *
 * @author Joe
 */
public class ProfilesDAO {
    
    private Session session;

    public ProfilesDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
}
