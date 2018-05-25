<%-- 
    Document   : blog-post
    Created on : May 26, 2018, 5:29:26 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="blog-post">
    <a href="<c:url value='/posts/${param.post_id}' />" class="text-dark"><h2 class="blog-post-title">${param.title}</h2></a>
    <p class="blog-post-meta">${param.created_at} by <a href="<c:url value='/users/${param.username}' />">${param.first_name}&nbsp;${param.last_name}</a></p>

    <p>${param.body}</p>
</div><!-- /.blog-post -->
