/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.dao;

import com.reconnect.model.Post;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface PostDAO {
    public void create(Post post);

    public List<Post> getPosts();

    public Post getPost(String id);
}
