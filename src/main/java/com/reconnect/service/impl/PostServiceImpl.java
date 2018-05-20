/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service.impl;

import com.reconnect.dao.PostDAO;
import com.reconnect.model.Post;
import com.reconnect.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Override
    public void create(Post post) {
        postdao.create(post);
    }
    
}
