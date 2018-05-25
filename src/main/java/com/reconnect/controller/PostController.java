/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.controller;

import com.reconnect.model.Post;
import com.reconnect.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */

@Controller
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/home", method = GET)
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("layouts/app");
        List<Post> posts = postService.getPosts();
        mv.addObject("posts", posts);
        return mv;
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/posts/create", method = GET)
    public ModelAndView create_page()
    {
        ModelAndView mv = new ModelAndView("layouts/post_create");
        return mv;
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/home", method = POST)
    public ModelAndView create(
        @RequestParam("title") String title,
        @RequestParam("body") String body
    )
    {
        postService.create(title, body);
        ModelAndView mv = new ModelAndView("layouts/app");
        return mv;
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = " /posts/{post_id}", method = GET)
    public ModelAndView specificPost(@PathVariable String post_id) 
    {
        Post post = postService.getPost(post_id);
        ModelAndView mv = new ModelAndView("layouts/post");
        return mv;
    }
}
