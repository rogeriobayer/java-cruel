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
    <h1>Cadastrar cardapio do dia 12/12/2021</h1>


    <form method="post" action="NutricionistaServlet?action=cadastrarCardapio">
        <div class="col-md-6">
            <div class="form-group">
                <label>Carne</label>
                <select id="carneAlmoco" name="carneAlmoco" class="custom-select">
                    <option selected>Selecione a carne</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" name="qtdCarneAlmoco" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Arroz</label>
                <select id="arrozAlmoco" name="arrozAlmoco" class="custom-select">
                    <option selected>Selecione o arroz</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Feijão</label>
                <select id="feijaoAlmoco" class="custom-select">
                    <option selected>Selecione o feijão</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Acompanhamento</label>
                <select id="acompanhamentoAlmoco" class="custom-select">
                    <option selected>Selecione o acompanhamento</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Salada</label>
                <select id="saladaAlmoco" class="custom-select">
                    <option selected>Selecione a salada</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Sobremesa</label>
                <select id="sobremesaAlmoco" class="custom-select">
                    <option selected>Selecione a sobremesa</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" placeholder="Quantidade">
            </div>
        </div>

        <div class="col-md-6">
            <div class="form-group">
                <label>Carne</label>
                <select id="carneJanta" name="carneJanta" class="custom-select">
                    <option selected>Selecione a carne</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtd" name="qtdCarneJanta" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Arroz</label>
                <select id="arrozJanta" name="arrozJanta" class="custom-select">
                    <option selected>Selecione o arroz</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtdarrozJanta" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Feijão</label>
                <select id="feijaoJanta" class="custom-select">
                    <option selected>Selecione o feijão</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtdfeijaoJanta" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Acompanhamento</label>
                <select id="acompanhamentoJanta" class="custom-select">
                    <option selected>Selecione o acompanhamento</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtdAcompanhamentoJanta" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Salada</label>
                <select id="saladaJanta" class="custom-select">
                    <option selected>Selecione a salada</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtdSaladaJanta" placeholder="Quantidade">
            </div>
            <div class="form-group">
                <label>Sobremesa</label>
                <select id="sobremesaJanta" class="custom-select">
                    <option selected>Selecione a sobremesa</option>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.nome}</option>
                    </c:forEach>
                </select>
                <input class="form-control" id="qtdsobremesaJanta" placeholder="Quantidade">
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</body>
</html>
