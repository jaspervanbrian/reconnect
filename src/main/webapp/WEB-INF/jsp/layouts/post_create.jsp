<%-- 
    Document   : post_create
    Created on : May 26, 2018, 3:52:35 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/images/reconnect-logo.png" var="icon" />
        <spring:url value="/resources/bootstrap-4.1.1/css/bootstrap.min.css" var="bootstrapCSS" />
        <spring:url value="/resources/css/playfair.css" var="playfair" />
        <spring:url value="/resources/css/blog.css" var="blog" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ReConnect</title>
        <link rel="icon" href="${icon}"/>

	<link href="${bootstrapCSS}" rel="stylesheet">
        <link rel="stylesheet" href="${playfair}">
        <link rel="stylesheet" href="${blog}">
    </head>

    <body>
        <div class="container">
            <jsp:include page="../partials/header.jsp"></jsp:include>
        </div>
        
        <main role="main" class="container">
            <div class="row">
                <div class="col-md-8 blog-main">
                    <form action="<c:url value='/home' />" method="post">
                        <h3 class="pb-3 mb-4 font-italic border-bottom">
                            Create a post
                        </h3>
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" name="title" id="title" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="body">Body</label>
                            <textarea name="body" class="form-control" id="body" cols="30" rows="10"></textarea>
                        </div>
                        <hr>
                        <div class="form-group">
                            <button type="submit" class="btn btn-dark btn-lg">Post</button>
                        </div>
                    </form>
                </div><!-- /.blog-main -->

                <jsp:include page="../partials/sidebar.jsp"></jsp:include>

            </div><!-- /.row -->

        </main><!-- /.container -->

        <jsp:include page="../partials/footer.jsp"></jsp:include>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <spring:url value="/resources/jquery-3.3.1/jquery-3.3.1.min.js" var="jquery" />
        <spring:url value="/resources/popper/popper.min.js" var="popper" />
        <spring:url value="/resources/bootstrap-4.1.1/js/bootstrap.min.js" var="bootstrapJS" />
        <spring:url value="/resources/holder/holder.min.js" var="holder" />
        <script src="${jquery}"></script>
        <script src="${popper}"></script>
        <script src="${bootstrapJS}"></script>
        <script src="${holder}"></script>
        <script>
            Holder.addTheme('thumb', {
                bg: '#55595c',
                fg: '#eceeef',
                text: 'Thumbnail'
            });
        </script>
    </body>
</html>
