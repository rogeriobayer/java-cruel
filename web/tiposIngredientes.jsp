<%-- 
    Document   : tiposIngredientes
    Created on : 12/12/2021, 01:48:31
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipos Ingredientes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="style/footer.css" type="text/css"/>
    </head>
    <body>

        <jsp:include page="./utilitarios/navbarNutricionista.jsp" />
        
        <div class = "container">
            <form action="${link}" method="post" name="form" id="form">
                <input id="id" name="id" value="${tipoIngrediente.id}" hidden>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome do Tipo de Ingrediente:</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="${tipoIngrediente.nome}" required>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-md-1">
                        <button type="submit" class="btn btn-success">Salvar</button>
                    </div>
                    <div class="form-group col-md-10"></div>
                </div>
            </form>
        </div>


        <div class="container">
            <table class="table ">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tiposIngredientes" items="${tiposIngredientes}">
                        <tr>
                            <td scope="row">${tiposIngredientes.nome}</td>
                            <td> 
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <a href="NutricionistaServlet?idTipo=${tiposIngredientes.id}&action=buscaAtualizaTipoIngrediente" type="button" class="btn btn-secondary">Alterar</a>
                                    <a href="" data-toggle="modal" data-target="#remove_${tiposIngredientes.id}" type="button" class="btn btn-secondary">Remover</a>

                                    <div class="modal fade" id="remove_${tiposIngredientes.id}" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Atenção!</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Tem certeza que deseja apagar o tipo de ingrediente ${tiposIngredientes.nome}?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <a href="NutricionistaServlet?id=${tiposIngredientes.id}&action=removerTipoIngrediente" class="btn btn-primary">Sim</a>
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


    </body>
</html>
