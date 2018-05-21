/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reconnect.service.impl;

import com.reconnect.dao.CommentDAO;
import com.reconnect.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentDAO commentdao;
    
}
