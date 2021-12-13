

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="erro.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



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
       
        <div class="container">

            <div id="portal-row" class="row justify-content-center portaluser-box">
                    <div id="portal-column" class="col-md-6 portaluser-box">
                        <div id="portal-box" class="col-md-12 portaluser-box">
                            <h3 class="text-center text-info">Atendente</h3>
       <form action="${not empty route ? route : "ClientesServlet?action=new"}" method="post" id="clientesNovo">
       <div>
          <div>
  <input 
    type="hidden" name="id" id="id" value="${not empty user ? user.getId() : ''}" />
          </div>
          <div>
              <label for="nome"><b>Nome</b></label><br><input 
             type="text" placeholder="Digite o nome" name="nome" id="nome" value="${not empty user ? user.getNome() : ''}" required minlength="2" maxlength="100"/>
           </div>
           <div>
          <label for="cpf"><b>CPF</b></label><br><input 
             type="text" placeholder="Digite o CPF" name="cpf" id="cpf" value="${not empty user ? user.getCpf() : ''}" required minlength="11" maxlength="11"/>
           </div>
           <div>
          <label for="email"><b>Email</b></label><br><input 
             type="text" placeholder="Digite o Email" name="email" id="email" value="${not empty user ? user.getEmail() : ''}" required minlength="2" maxlength="100"/>
          </div>
          <div>
          <label for="rua"><b>Endereço</b></label><br>
            <input type="text" placeholder="Digite a Endereço" name="endereco" id="endereco" value="${not empty user ? user.getEndereco() : ''}" required minlength="2" maxlength="100"/>
           </div>
          <div>
          <label for="numero"><b>Telefone</b></label><br>
          <input type="text" placeholder="Digite o Telefone" name="telefone" id="telefone" value="${not empty user ? user.getTelefone() : ''}" required maxlength="5"/>
          </div>
          <div>
          <label for="date"><b>Data</b></label><br>
                <input type="date" name="date" id="date" value="${not empty user ? user.getDate().toLocalDate() :''}" required/>
          </div>
          <div>
                  </div>
          <button type="button" class="btn btn-danger">
              <a class="text-white" href="PortalServlet">Cancelar</a>
          </button>
          <button type="submit" class="btn btn-success">
            Salvar
          </button>
       </div>
     </form>
                        </div>
                        
                    </div>  

           
            </div>
        </div>
    </div>
</body>

</html>
