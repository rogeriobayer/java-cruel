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
    <h1>Cardapio do dia 12/12/2021</h1>

    <div class="card" style="width: 18rem;">
        <div class="card-header">
            Almoco
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Cras justo odio</li>
            <li class="list-group-item">Dapibus ac facilisis in</li>
            <li class="list-group-item">Vestibulum at eros</li>
        </ul>
    </div>

    <div class="card" style="width: 18rem;">
        <div class="card-header">
            Janta
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Cras justo odio</li>
            <li class="list-group-item">Dapibus ac facilisis in</li>
            <li class="list-group-item">Vestibulum at eros</li>
        </ul>
    </div>
</body>
</html>
