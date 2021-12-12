<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Portal</title>
        <link rel="stylesheet" href="style/footer.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="./utilitarios/navbarNutricionista.jsp" />

        <div class="card">
            <div class="card-body">
                Bem vindo nutricionista,  ${usuario.nome}
            </div>
        </div>

        <footer class="footer">
        </footer>
    </body>
</html>
