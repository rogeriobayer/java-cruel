<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">                
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="NutricionistaServlet">Início</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="NutricionistaServlet?action=cardapios">Lista de Cardápios do Mês</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="NutricionistaServlet?action=tiposIngredientes">Tipos de Ingrediente</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="NutricionistaServlet?action=ingredientes">Ingredientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Sair</a>
                </li>

            </ul>
        </div>
    </div>
</nav>