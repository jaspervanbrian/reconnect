/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service;

import com.reconnect.model.Post;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface PostService {
    public void create(String title, String body);
    
    public List<Post> getPosts();

    public Post getPost(String id);
}
