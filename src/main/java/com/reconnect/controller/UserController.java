/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.controller;

import com.reconnect.model.User;
import com.reconnect.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/register", method = POST)
    public ModelAndView register(
        @RequestParam("first_name") String first_name,
        @RequestParam("last_name") String last_name,
        @RequestParam("email_address") String email_address,
        @RequestParam("username") String username,
        @RequestParam("password") String password
    )
    {
        ArrayList<String> duplicates = userService.checkDuplicates(email_address, username);
        if(duplicates.size() > 0) {
            ModelAndView mv = new ModelAndView("index");
            if(duplicates.contains("username")) {
                mv.addObject("username", "error");
            }
            if(duplicates.contains("email_address")) {
                mv.addObject("email_address", "error");
            }
            mv.addObject("old_email_address", email_address);
            mv.addObject("old_username", username);
            mv.addObject("old_first_name", first_name);
            mv.addObject("old_last_name", last_name);
            return mv;
        }
        User user = new User();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setEmail_address(email_address);
        user.setUsername(username);
        user.setPassword(password);
        userService.create(user);
        
        ModelAndView mv = new ModelAndView("layouts/app");
        return mv;
    }
    
    @RequestMapping(value = "/users", method = GET)
    @ResponseBody
    public List<User> index()
    {
        return userService.users();
    }
}
