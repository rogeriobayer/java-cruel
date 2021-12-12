<%-- 
    Document   : login
    Created on : 9 de dez. de 2021, 18:23:36
    Author     : bayer
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="erro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - CRUEL</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="styles.css">
    </head>
   <body>
    <div id="login">
        <h3 class="text-center text-white pt-5">CRUEL</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12 d-flex flex-column justify-content-center ">
                        
                        <form id="login-form" class="form " action="LoginServlet" method="post"> 
                            <h3 class="text-center text-info">Login</h3>
                            <c:if test="${not empty erro || not empty param.erro}" >
                                <div id="login-row" class="justify-content-center align-items-center">
                                          <div class="alert alert-danger" role="alert"> 
                                    ${erro} ${param.erro}
                                </div>
                            </c:if>
                                    
                              <c:if test="${not empty info || not empty param.info}" >
                                <div id="login-row" class="justify-content-center align-items-center">
                                          <div class="alert alert-info" role="alert"> 
                                    ${info} ${param.info}
                                </div>
                            </c:if>
                            
                            <div class="form-group">
                                <label for="login" class="text-info">Login:</label><br>
                                <input type="text" name="login" id="login" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Enviar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
