<%-- 
    Document   : portalatendente
    Created on : 11/12/2021, 14:22:06
    Author     : tomat
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="erro.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
            $(document).ready(function () {
        
            function zeroPadded(val) {
           if (val >= 10)
             return val;
           else
             return '0' + val;
         }

           d = new Date();
           $('input[type=datetime-local]').val(d.getFullYear()+"-"+zeroPadded(d.getMonth() + 1)+"-"+zeroPadded(d.getDate())+"T"+d.getHours()+":"+d.getMinutes()+":00");
             $('#price').mask('#.##0,00', {reverse: true});
         });
</script>
 <div id="portal-column" class="col-md-6">
    <div id="portal-box" class="col-md-12">
        <h3 class="text-center text-info">Resumo de Almoços</h3>
            <h5 class="text-center text-info">330 almoços renderam R$225.054,00 </h5>
        <table class="table">
         <thead>
            <tr>
               <th>Categoria:</th>
               <th>Quantidade:</th>
               <th>Total Arrecadado:</th>
            </tr>
         </thead>
         <tbody>
            <%--<c:forEach items="${aa}" var="x">--%>
            <tr>
               <td>Aluno</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
              <tr>
               <td>Professor</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
               <tr>
               <td>Servidor</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
              <tr>
               <td>Externos e outras categorias</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
         </tbody>
         <%--<c:forEach>--%>
      </table>
    </div>
    <div id="portal-box" class="col-md-12">
        <h3 class="text-center text-info">Resumo de Jantares</h3>
                  <h5 class="text-center text-info">330 jantares renderam R$225.054,00 </h5>
        <table class="table">
         <thead>
            <tr>
               <th>Categoria:</th>
               <th>Quantidade:</th>
               <th>Total Arrecadado:</th>
            </tr>
         </thead>
         <tbody>
            <%--<c:forEach items="${aa}" var="x">--%>
            <tr>
               <td>Aluno</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
              <tr>
               <td>Professor</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
               <tr>
               <td>Servidor</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
              <tr>
               <td>Externos e outras categorias</td>
               <td>500  </td>
               <td> RS 10000,30 </td>
            </tr>
         </tbody>
         <%--<c:forEach>--%>
      </table>
     </div>
      <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Cadastro de Gerentes</h3>
     <table class="table">
         <thead>
            <tr>
               <th>Nome:</th>
               <th>CPF:</th>
               <th>Data Nascimento</th>
               <th>Ações:</th>
            </tr>
         </thead>
         <tbody>
            <%--<c:forEach items="${aa}" var="x">--%>
            <tr>
               <td> Joao </td>
               <td> 154.506.199-00 </td>
               <td> 12/12/2002 </td>
               <td>
                  <a href="xxxServlet?action=update&id=" title="Editar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" 
                        viewBox="0 0 16 16">
                        <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                     </svg>
                  </a>
                  <a class="removebutton" href="#" onclick="deleteData()" title="Deletar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                        class="bi bi-trash"  viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 
                           0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1
                           0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 
                           2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1
                           0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 
                           3V2h11v1h-11z"/>
                     </svg>
                  </a>
               </td>
            </tr>
         </tbody>
         <%--<c:forEach>--%>
      </table>
   </div>
       <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Cadastro de Categorias</h3>
     <table class="table">
         <thead>
            <tr>
               <th>Categoria:</th>
               <th>Preço:</th>
                              <th>Ações</th>

            </tr>
         </thead>
         <tbody>
            <%--<c:forEach items="${aa}" var="x">--%>
            <tr>
               <td> Joao </td>
               <td> 154.506.199-00 </td>
            
               <td>
                  <a href="xxxServlet?action=update&id=" title="Editar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" 
                        viewBox="0 0 16 16">
                        <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                     </svg>
                  </a>
                  <a class="removebutton" href="#" onclick="deleteData()" title="Deletar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                        class="bi bi-trash"  viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 
                           0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1
                           0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 
                           2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1
                           0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 
                           3V2h11v1h-11z"/>
                     </svg>
                  </a>
               </td>
            </tr>
         </tbody>
         <%--<c:forEach>--%>
      </table>
   </div>
      
 </div>  

<div id="portal-column" class="col-md-6">
   <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Cadastro de Clientes</h3>
     <table class="table">
         <thead>
            <tr>
               <th>Nome:</th>
               <th>CPF:</th>
               <th>Data Nascimento</th>
               <th>Ações:</th>
            </tr>
         </thead>
         <tbody>
            <%--<c:forEach items="${aa}" var="x">--%>
            <tr>
               <td> Joao </td>
               <td> 154.506.199-00 </td>
               <td> 12/12/2002 </td>
               <td>
                  <a href="xxxServlet?action=update&id=" title="Editar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" 
                        viewBox="0 0 16 16">
                        <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                     </svg>
                  </a>
                  <a class="removebutton" href="#" onclick="deleteData()" title="Deletar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                        class="bi bi-trash"  viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 
                           0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1
                           0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 
                           2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1
                           0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 
                           3V2h11v1h-11z"/>
                     </svg>
                  </a>
               </td>
            </tr>
         </tbody>
         <%--<c:forEach>--%>
      </table>
   </div>
   <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Cadastro de Atendentes</h3>
      <table class="table">
         <thead>
            <tr>
               <th>Nome:</th>
               <th>CPF:</th>
               <th>Data Nascimento</th>
               <th>Ações:</th>
            </tr>
         </thead>
         <tbody>
 <c:forEach var="atendente" items="${atendentes}">
                    <tr>
                        <td scope="row">${atendente.nome}</td>
                        <td scope="row">${atendente.cpf}</td>
                        <td scope="row">${atendente.date}</td>
                        <td> 
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="AtendenteServlet?id=${atendente.id}&action=formUpdate" type="button" class="btn btn-secondary">Alterar</a>
                                <a href="AtendenteServlet?id=${atendente.id}&action=delete" type="button" class="btn btn-secondary">Remover</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>      
      </tbody>
      </table>
   </div>
   <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Cadastro de Nutricionistas</h3>
      <table class="table">
         <thead>
            <tr>
               <th>Nome:</th>
               <th>CPF:</th>
               <th>Data Nascimento</th>
               <th>Ações:</th>
            </tr>
         </thead>
         <tbody>
            <%--<c:forEach items="${aa}" var="x">--%>
            <tr>
               <td> Ana Flávia </td>
               <td> 1054.506.199-00 </td>
               <td> RS 1,30 </td>
               <td>
                  <a href="xxxServlet?action=update&id=" title="Editar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" 
                        viewBox="0 0 16 16">
                        <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                     </svg>
                  </a>
                  <a class="removebutton" href="#" onclick="deleteData()" title="Deletar">
                     <svg 
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                        class="bi bi-trash"  viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 
                           0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1
                           0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 
                           2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1
                           0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 
                           3V2h11v1h-11z"/>
                     </svg>
                  </a>
               </td>
            </tr>
         </tbody>
         <%--<c:forEach>--%>
      </table>
   </div>
    <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Relatórios</h3>
      <button class="btn btn-primary align-self-center my-2" onclick="location.href='xxxServlet'" type="button">Relatório de Receita Mensal (PDF)</button> <br>
        <button class="btn btn-primary align-self-center my-2" onclick="location.href='xxxServlet'" type="button">Relatório de Receita Anual (PDF)</button><br>
        <button class="btn btn-primary align-self-center my-2" onclick="location.href='xxxServlet'" type="button">Relatório de Usuário (PDF)</button><br>
   </div>
</div>
