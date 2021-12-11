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
        <script>
            $(document).ready(function () {
        
   function zeroPadded(val) {
  if (val >= 10)
    return val;
  else
    return '0' + val;
}
   
  d = new Date();
  $('input[type=datetime-local]').val(d.getFullYear()+"-"+zeroPadded(d.getMonth() + 1)+"-"+zeroPadded(d.getDate())+"T"+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
    $('#price').mask('#.##0,00', {reverse: true});
});
        </script>
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
                <c:if test="${login.getCargo().equals(\"ger\")}" > 
                 <div id="portal-column" class="col-md-6">
                    <div id="portal-box" class="col-md-12">
               <h3 class="text-center text-info">Registrar Cliente</h3>
                <form id="portal-form" class="form" action="ClienteServlet" method="post"> 
                            <div class="form-group">
                                <label for="login" class="text-info">CPF:</label><br>
                                <input type="text" name="cpf" id="cpf" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="datepicker" class="text-info">Data e Hora</label><br>
<input type="datetime-local" id="publishDate" required/>
                            </div>
                            <div class="form-group">
                                <label for="price" class="text-info">Valor Pago (R$):</label><br>
                                <input type="text" name="price" id="price" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Salvar Registro">
                            </div>
                        </form>                     
                    </div>
                    
                    <div id="portal-box" class="col-md-12">
                        <h3 class="text-center text-info">Consultar os registros</h3>
                        <table class="table">  <thead><tr>
                <th>Data:</th>
                <th>CPF:</th>
                <th>Valor Pago:</th>
                <th>Ações:</th>
                </tr></thead>
                <tbody>
                    <%--<c:forEach items="${aa}" var="x">--%>
                    <tr> 
                        <td> 12/05/2021 15:30:31 </td>
                        <td> 1054.506.199-00 </td>
                        <td> RS 1,30 </td>
                              <td><a href="xxxServlet?action=update&id=" title="Editar"><svg 
                    xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" 
                    viewBox="0 0 16 16"> <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/></svg></a>
                   <a class="removebutton" href="#" onclick="deleteData()" title="Deletar"><svg 
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                class="bi bi-trash"  viewBox="0 0 16 16"> <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 
                                0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1
                                0v6a.5.5 0 0 0 1 0V6z"/>  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 
                                2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1
                                0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 
                                3V2h11v1h-11z"/></svg></a></td>
                    </tr>
                </tbody>
                <%--<c:forEach>--%>
                        </table>
                    </div>
                    
                   
                </div>
            </c:if>

            </div>
        </div>
    </div>
</body>

</html>
