<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date"/>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>


<c:if test="${empty login}" >
    <jsp:forward page="login.jsp"> 
        <jsp:param name="erro" value="Usuário deve se autenticar para acessar o sistema"/> 
    </jsp:forward> 
</c:if>

<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atendimento</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="style/footer.css" type="text/css"/>
    </head>
</head>
<body>
    <div class="container">
        <h1>Atendimento número: ${atendimento.id} </h1>
    <form id="portal-form" class="form" action="ClienteServlet" method="post">
        <input type="hidden" name="id" value="${atendimento.id}"/>
        <input type="hidden" name="action" value="${action}"/>
        <div class="form-group">
            <label for="login" class="text-info" >CPF:</label><br>
            <input type="text" name="cpf" id="cpf" class="form-control" value="${atendimento.cpf}" ${action=="delete"?"readonly":""} required>
        </div>
        <div class="form-group">
            <label for="datepicker" class="text-info">Data e Hora</label><br>
            <input type="datetime-local" name="dataHora" id="publishDate" value="<fmt:formatDate value="${atendimento.dataHora}" pattern="yyyy-MM-dd\'T\'HH:mm:ss" />" ${action=="delete"?"readonly":""} required/>
        </div>
        <div class="form-group">
            <label for="price" class="text-info" >Valor Pago (R$):</label><br>
            <input type="text" name="price" id="price" class="form-control" value="<fmt:formatNumber type = "number" pattern = "######0.0" value = "${atendimento.valor}" />" ${action=="delete"?"readonly":""} required>
        </div>
        <div class="form-floating">
            <label for="floatingTextarea2" class="text-info">Justificativa</label>
            <textarea class="form-control" name="justificativa" id="floatingTextarea2" style="height: 100px" value="${atendimento.justificativa}" maxlength="255" required></textarea>    
        </div>
         <div class="form-group">
             <a href="portal.jsp" class="btn btn-outline-secondary btn-md">Cancelar</a> 
         </div>
        <div class="form-group">
            <input type="submit" name="submit" class="btn btn-info btn-md" value="Salvar Alterações">
        </div>
      </form>
    </div>   
</body>
</html>
