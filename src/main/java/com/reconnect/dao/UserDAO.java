/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.dao;

import com.reconnect.model.User;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface UserDAO {
    public void create(User user);

    public List<User> getUsers();
}
