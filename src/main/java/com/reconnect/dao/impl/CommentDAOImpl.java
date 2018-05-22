/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.dao.impl;

import com.reconnect.dao.CommentDAO;
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
public class CommentDAOImpl implements CommentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
}
