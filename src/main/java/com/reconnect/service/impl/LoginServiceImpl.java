/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service.impl;

import com.reconnect.dao.UserDAO;
import com.reconnect.model.User;
import com.reconnect.service.LoginService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private UserDAO userdao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userdao.findByUsername(username);
        
        if(user == null) {
            throw new UsernameNotFoundException("Username was not found in the database.");
        }
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole_name());
        grantList.add(authority);
        
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantList);
        
        return userDetails;
    }
    
}
