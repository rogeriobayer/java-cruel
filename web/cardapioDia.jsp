<%-- 
    Document   : cardapioDia
    Created on : 12/12/2021, 06:44:02
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date"/>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cardápios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="style/footer.css" type="text/css"/>
    </head>
</head>
<body>
    <jsp:include page="./utilitarios/navbarNutricionista.jsp" />
    <div class = "container">
        <h1>Cardapio do dia ${cardapio.data}</h1>

        <div class="row">
            <c:forEach var="refeicoes" items="${cardapio.refeicoes}">
            <div class="card col-md-6" >
                <div class="card-header">
                    ${refeicoes.turno}
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <c:forEach var="refIng" items="${refeicoes.refIng}">
                            <li class="list-group-item">${refIng.nome}</li>
                            </c:forEach>
                    </ul>
                </div>
            </div>
        </c:forEach>
        </div>
        

</body>
</html>
