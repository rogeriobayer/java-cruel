/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.TipoIngrediente;
import com.ufpr.tads.web2.facade.CalendarioFacade;
import com.ufpr.tads.web2.facade.TipoIngredienteFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author julia
 */
@WebServlet(name = "NutricionistaServlet", urlPatterns = {"/NutricionistaServlet"})
public class NutricionistaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String action = request.getParameter("action");

                if (action == null || action.isEmpty() || action.equals("")) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/portalNutricionista.jsp");
                    rd.forward(request, response);

                }else if (action.equals("cardapios")) {
                    
                    
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cardapios.jsp");
                    rd.forward(request, response);

                }else if (action.equals("tiposIngredientes")) {
                    List<TipoIngrediente> tiposIngredientes = TipoIngredienteFacade.buscarTodos();
                    request.setAttribute("tiposIngredientes", tiposIngredientes);
                    
                    request.setAttribute("link", "NutricionistaServlet?action=novoTipoIngrediente");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/tiposIngredientes.jsp");
                    rd.forward(request, response);

                }else if (action.equals("buscaAtualizaTipoIngrediente")) {
                    List<TipoIngrediente> tiposIngredientes = TipoIngredienteFacade.buscarTodos();
                    request.setAttribute("tiposIngredientes", tiposIngredientes);
                    
                    TipoIngrediente ti = new TipoIngrediente();
                    
                    String idString = request.getParameter("idTipo");
                    int id = Integer.parseInt(idString);
                    
                    ti.setId(id);
                    
                    ti = TipoIngredienteFacade.buscar(ti);;
                    request.setAttribute("tipoIngrediente", ti);
                    
                    request.setAttribute("link", "NutricionistaServlet?action=atualizaTipoIngrediente");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/tiposIngredientes.jsp");
                    rd.forward(request, response);

                }else if (action.equals("novoTipoIngrediente") || action.equals("atualizaTipoIngrediente")) {
                    TipoIngrediente ti = new TipoIngrediente();
                    
                    ti.setNome(request.getParameter("nome"));
                    
                    if (action.equals("atualizaTipoIngrediente")) {
                        ti.setId(Integer.parseInt(request.getParameter("id")));
                        TipoIngredienteFacade.editar(ti);
                    }
                    if (action.equals("novoTipoIngrediente")) {
                        TipoIngredienteFacade.inserir(ti);
                    }
                    response.sendRedirect("./NutricionistaServlet?action=tiposIngredientes");

                }else if (action.equals("removerTipoIngrediente")) {
                    String idString = request.getParameter("id");
                    int id = Integer.parseInt(idString);
                    TipoIngredienteFacade.remover(id);
                    response.sendRedirect("./NutricionistaServlet?action=tiposIngredientes");

                }else if (action.equals("ingredientes")) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ingredientes.jsp");
                    rd.forward(request, response);

                }else if (action.equals("consultarCardapio")) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cardapioDia.jsp");
                    rd.forward(request, response);

                }else if (action.equals("cadastrarCardapioForm")) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cardapioCadastrar.jsp");
                    rd.forward(request, response);

                }else if (action.equals("cadastrarCardapio")) {
                    TipoIngrediente ti = new TipoIngrediente();
                    
                    ti.setNome(request.getParameter("nome"));
                    
                    request.getParameter("carneAlmoco");

                }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NutricionistaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NutricionistaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
