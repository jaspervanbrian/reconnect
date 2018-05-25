/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.controller;

import com.reconnect.model.Post;
import com.reconnect.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */

@Controller
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @RequestMapping(value = "/posts", method = POST)
    public String create()
    {
        Post post = new Post();
        return "";
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/home", method = GET)
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("layouts/app");
        return mv;
    }
}
