<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.reconnect.model.Post"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
            <jsp:include page="../partials/banner.jsp"></jsp:include>
        </div>

        <main role="main" class="container">
            <div class="row">
                <div class="col-md-8 blog-main">
                    <h3 class="pb-3 mb-4 font-italic border-bottom">
                        From the Firehose
                    </h3>

                    <%
                        List<Post> posts = (List<Post>)request.getAttribute("username");
                        for(Post post : posts) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy - hh:mm aaa");
                            String created_at = dateFormat.format(post.getCreated_at());
                    %>
                            <jsp:include page="../partials/blog-post.jsp">
                                <jsp:param name="post_id" value="<%= post.getUser().getLast_name()%>"></jsp:param>
                                <jsp:param name="title" value="<%= post.getTitle() %>"></jsp:param>
                                <jsp:param name="body" value="<%= post.getBody() %>"></jsp:param>
                                <jsp:param name="created_at" value="<%= created_at %>"></jsp:param>
                                <jsp:param name="username" value="<%= post.getUser().getUsername() %>"></jsp:param>
                                <jsp:param name="first_name" value="<%= post.getUser().getFirst_name() %>"></jsp:param>
                                <jsp:param name="last_name" value="<%= post.getUser().getLast_name()%>"></jsp:param>
                            </jsp:include>
                    <%
                        }
                    %>
                    <nav class="blog-pagination">
                        <a class="btn btn-outline-primary" href="#">Older</a>
                        <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
                    </nav>

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
