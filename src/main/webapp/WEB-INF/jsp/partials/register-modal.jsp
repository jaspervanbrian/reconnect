<%-- 
    Document   : login-modal
    Created on : May 24, 2018, 3:20:38 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="login_modalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="login_modalLabel">Sign up for free!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/" method="post">
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="first_name">First Name</label>
                                    <input type="text" name="first_name" class="form-control" value="${param.old_first_name}" required>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="last_name">Last Name</label>
                                    <input type="text" name="last_name" class="form-control" value="${param.old_last_name}" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="email_address">Email address</label>
                                    <input type="email" name="email_address" class="form-control ${param.email_address.equals("error") ? 'is-invalid' : ''}" value="${param.old_email_address}" required>
                                    <span class="${param.email_address.equals("error") ? 'form-text text-danger' : ''}">
                                        ${param.email_address.equals("error") ? 'This email address is already taken.' : ''}
                                    </span>
                                </div>
                            </div>
                        </div>
                        <hr>   
                        <div class="row">
                            <div class="col-6">
                                <p><strong>Login Credentials</strong></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <input type="text" name="username" class="form-control ${param.username.equals("error") ? 'is-invalid' : ''}" value="${param.old_username}" required>
                                    <span class="${param.username.equals("error") ? 'form-text text-danger' : ''}">
                                        ${param.username.equals("error") ? 'This username is already taken.' : ''}
                                    </span>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" name="password" class="form-control" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 text-center">
                                <button class="btn btn-primary">Sign up</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
