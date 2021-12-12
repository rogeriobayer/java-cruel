<%-- 
    Document   : cardapioCadastrar
    Created on : 12/12/2021, 06:49:28
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
    <h1>Cadastrar cardapio do dia 12/12/2021 - ALMOCO</h1>

    <form method="post" action="NutricionistaServlet?action=cadastrarCardapio">
        <div class="form-group">
            <label>Carne</label>
            <select id="carneAlmoco" class="custom-select">
                <option selected>Selecione a carne</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <input class="form-control" id="qtd" placeholder="Quantidade">
        </div>
        <div class="form-group">
            <label>Arroz</label>
            <select id="arrozAlmoco" class="custom-select">
                <option selected>Selecione o arroz</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <input class="form-control" id="qtd" placeholder="Quantidade">
        </div>
        <div class="form-group">
            <label>Feijão</label>
            <select id="feijaoAlmoco" class="custom-select">
                <option selected>Selecione o feijão</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <input class="form-control" id="qtd" placeholder="Quantidade">
        </div>
        <div class="form-group">
            <label>Acompanhamento</label>
            <select id="acompanhamentoAlmoco" class="custom-select">
                <option selected>Selecione o acompanhamento</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <input class="form-control" id="qtd" placeholder="Quantidade">
        </div>
        <div class="form-group">
            <label>Salada</label>
            <select id="saladaAlmoco" class="custom-select">
                <option selected>Selecione a salada</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <input class="form-control" id="qtd" placeholder="Quantidade">
        </div>
        <div class="form-group">
            <label>Sobremesa</label>
            <select id="sobremesaAlmoco" class="custom-select">
                <option selected>Selecione a sobremesa</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <input class="form-control" id="qtd" placeholder="Quantidade">
        </div>
        
        

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</body>
</html>
