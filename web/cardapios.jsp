<%-- 
    Document   : cardapios
    Created on : 12/12/2021, 01:48:16
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date"/>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cardápios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="style/footer.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="./utilitarios/navbarNutricionista.jsp" />

        <div class = "container">
            <form method="post" action="NutricionistaServlet?action=cardapiosMes">
                <div class="row">
                    <div class="form-group col-md-3">
                        <select name="mes" id="mes" class="form-control" aria-label="Default select example">
                            <option selected>Selecione o mes</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control" id="ano" name="ano" aria-label="Default select example">
                    </div>
                    <div class="form-group col-md-1">
                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </div>
                </div>

            </form>

            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">dia</th>
                        <th scope="col">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cardapios" items="${cardapios}">
                        <tr>
                            <td>${cardapios.diaMes}</td>
                            <td>
                                <a href="NutricionistaServlet?action=consultarCardapio&id=${cardapios.id}" class="btn btn-primary">Consultar</a>

                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
            <a href="NutricionistaServlet?action=cadastrarCardapioForm" class="btn btn-primary">Cadastrar</a>
        </div>




    </body>
</html>
