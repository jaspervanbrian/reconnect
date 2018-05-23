<%-- 
    Document   : index
    Created on : May 24, 2018, 2:30:24 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <spring:url value="/resources/images/reconnect-logo.png" var="icon" />
        <spring:url value="/resources/bootstrap-4.1.1/css/bootstrap.min.css" var="bootstrapCSS" />
        <spring:url value="/resources/css/login.css" var="login" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="icon" href="${icon}"/>

        <link href="${bootstrapCSS}" rel="stylesheet">
        <link rel="stylesheet" href="${login}">
    </head>

    <body>
        <form class="form-signin">
            <div class="jumbotron" id="login-details">
                <div class="text-center mb-4">
                    <img class="mb-4" src="${icon}" alt="" height="100">
                    <h1 class="h3 mb-3 font-weight-normal">Welcome to ReConnect.</h1>
                    <p><strong>Discover more people worth reconnecting with.</strong></p>
                </div>

                <div class="form-label-group">
                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                    <label for="inputEmail">Email address</label>
                </div>

                <div class="form-label-group">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <label for="inputPassword">Password</label>
                </div>

                <div class="form-label-group text-center">
                    <a href="#!" data-toggle="modal" data-target="#login_modal">Don't have account yet?</a>
                </div>
                    
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
            </div>
        </form>
        <jsp:include page="partials/login-modal.jsp"></jsp:include>
        
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
