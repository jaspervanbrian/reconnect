/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service.impl;

import com.reconnect.dao.UserDAO;
import com.reconnect.model.User;
import com.reconnect.service.UserService;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<User> users() 
    {
        return userdao.getUsers();
    }

    @Override
    public ArrayList<String> checkDuplicates(String email_address, String username) {
        ArrayList<String> duplicate_fields = new ArrayList<String>();
        List<User> duplicate_users = userdao.checkDuplicates(email_address, username);
        if(duplicate_users.size() > 0) {
            for(User user : duplicate_users) {
                if(user.getUsername().equals(username)) {
                    duplicate_fields.add("username");
                }
                if(user.getEmail_address().equals(email_address)) {
                    duplicate_fields.add("email_address");
                }
                if(duplicate_fields.size() == 2) {
                    break;
                }
            }
        }
        return duplicate_fields;
    }
}
