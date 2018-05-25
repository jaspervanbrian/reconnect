/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.dao.impl;

import com.reconnect.dao.PostDAO;
import com.reconnect.model.Post;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
public class PostDAOImpl implements PostDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void create(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(post);
    }

    @Override
    public List<Post> getPosts() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Post.class);
        List<Post> posts = criteria.addOrder(Order.desc("created_at")).list();
        return posts;
    }

    @Override
    public Post getPost(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Post.class);
        
        criteria.add(Restrictions.eq("id", id));
        List<Post> posts = criteria.list();
        if(posts.size() > 0) {
            for(Post post : posts) {
                return post;
            }
        }
        return null;
    }
    
}
