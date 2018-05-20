/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.dao.impl;

import com.reconnect.dao.PostDAO;
import com.reconnect.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */

@Repository
@Transactional
public class PostDAOImpl implements PostDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void create(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(post);
    }
    
}
