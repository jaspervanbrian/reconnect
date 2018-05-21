/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service.impl;

import com.reconnect.dao.UserDAO;
import com.reconnect.model.User;
import com.reconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userdao;

    @Override
    public void create(User user) 
    {
        userdao.create(user);
    }
}
