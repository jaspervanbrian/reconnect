/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.dao.impl;

import com.reconnect.dao.UserDAO;
import com.reconnect.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public List<User> getUsers() 
    {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = criteria.list();
        return users;
    }

    @Override
    public List<User> checkDuplicates(String email_address, String username) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        
        Criterion duplicate_email_address = Restrictions.eq("email_address", email_address);
        Criterion duplicate_username = Restrictions.eq("username", username);
        LogicalExpression or = Restrictions.or(duplicate_email_address, duplicate_username);
        
        criteria.add(or);
        List<User> duplicate_users = criteria.list();
        return duplicate_users;
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        
        criteria.add(Restrictions.eq("username", username));
        List<User> users = criteria.list();
        if(users.size() > 0) {
            for(User user : users) {
                return user;
            }
        }
        return null;
    }
    
    
}
