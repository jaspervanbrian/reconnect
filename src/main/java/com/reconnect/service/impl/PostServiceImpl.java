/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service.impl;

import com.reconnect.dao.PostDAO;
import com.reconnect.dao.UserDAO;
import com.reconnect.model.Post;
import com.reconnect.model.User;
import com.reconnect.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postdao;
    
    @Autowired
    private UserDAO userdao;
    
    @Override
    public void create(String title, String body) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username
        User user = userdao.findByUsername(username);
        
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);
        postdao.create(post);
    }

    @Override
    public List<Post> getPosts() {
        return postdao.getPosts();
    }

    @Override
    public Post getPost(String id) {
        return postdao.getPost(id);
    }
    
}
