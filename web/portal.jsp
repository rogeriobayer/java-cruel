<%-- 
    Document   : portal
    Created on : 9 de dez. de 2021, 18:23:36
    Author     : bayer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="erro.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty param.login}" >
    <jsp:forward page="login.jsp"> 
        <jsp:param name="erro" value="Usuário deve se autenticar para acessar o sistema"/> 
    </jsp:forward> 
</c:if>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal - CRUEL</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>    
        <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>      
          <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.11.2/jquery.mask.min.js"></script>
        <link rel="stylesheet" href="styles.css">
 
    </head>
   <body>
    <div id="portal" >
        <h3 class="text-center text-white pt-5">CRUEL</h3>
        <div class="container">
            <div id="portal-row" class="row justify-content-center align-items-center">
                <div id="portal-column" class="col-md-6">
                    <div id="portal-box" class="col-md-12">
                        <h3 class="text-center text-info">Cardapio do dia</h3>
                    </div>
                    <div id="portal-box" class="col-md-12">
                        <h3 class="text-center text-info">Cardapio da semana</h3>
                    </div>
                </div>                     
                <c:if test="${login.getCargo().equals(\"ate\")}" > 
                    <%@ include file="portalatendente.jsp" %>
                </c:if>
                <c:if test="${login.getCargo().equals(\"ger\")}" > 
                    <%@ include file="portalgerente.jsp" %>
                </c:if>
            </div>
        </div>
    </div>
</body>

</html>
