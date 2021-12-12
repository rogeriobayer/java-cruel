<%-- 
    Document   : portalatendente
    Created on : 11/12/2021, 14:22:06
    Author     : tomat
--%>

<script>
            $(document).ready(function () {
        
            function zeroPadded(val) {
                if (val >= 10)
                  return val;
                else
                  return '0' + val;
              }

           d = new Date();
           $('input[type=datetime-local]').val(d.getFullYear()+"-"+zeroPadded(d.getMonth() + 1)+"-"+zeroPadded(d.getDate())+"T"+zeroPadded(d.getHours())+":"+zeroPadded(d.getMinutes())+":00");
             $('#price').mask('#.##0,00', {reverse: true});
         });
         
        function getRegistros(){

            var url = "ClienteServlet?action=listar";
            $.ajax({
                    url : url, // URL da sua Servlet
                    data : {}, // Parâmetro passado para a Servlet
                    dataType : 'json',
                    success : function(data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        
                        console.log(data);
                        $("#tbRegistros").empty();
                        $.each(data, function(i, obj) {
                            $("#tbRegistros").append(
                                    '<tr>' + 
                                    '  <td>' + obj.dataHora +'</td>' +
                                    '  <td>' + obj.cpf +'</td>' +
                                    '  <td>' + obj.valor +'</td>' +
                                    '  <td>' +
                                    '   <a href="ClienteServlet?action=update&id='+obj.id+'" title="Editar">'+
                                    '     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" ' +
                                    '          viewBox="0 0 16 16">'+
                                    '       <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>' +
                                    '     </svg>' +
                                    '   </a>' +
                                    '   <a class="removebutton" href="ClienteServlet?action=delete&id='+obj.id+'" title="Deletar">'+
                                    '     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" '+
                                    '          class="bi bi-trash"  viewBox="0 0 16 16">'+
                                    '       <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 \
                           0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1\
                           0v6a.5.5 0 0 0 1 0V6z"/>\
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 \
                           2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1\
                           0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 \
                           3V2h11v1h-11z"/>'+
                                    '     </svg>'+
                                    '     </a>' +
                                    '  </td>' +
                                    '</tr>'
                            );

                        });
                    }
                });
        }
        getRegistros();

</script>
<div id="portal-column" class="col-md-6">
   <div id="portal-box" class="col-md-12">
      <h3 class="text-center text-info">Registrar Cliente</h3>
      <form id="portal-form" class="form" action="ClienteServlet?action=insert" method="post">
         <div class="form-group">
            <label for="login" class="text-info">CPF:</label><br>
            <input type="text" name="cpf" id="cpf" class="form-control">
         </div>
         <div class="form-group">
            <label for="datepicker" class="text-info">Data e Hora</label><br>
            <input type="datetime-local" name="dataHora" id="publishDate" required/>
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
      <table class="table">
         <thead>
            <tr>
               <th>Data:</th>
               <th>CPF:</th>
               <th>Valor Pago:</th>
               <th>Ações:</th>
            </tr>
         </thead>
         <tbody id="tbRegistros">
         </tbody>
      </table>
   </div>
</div>
