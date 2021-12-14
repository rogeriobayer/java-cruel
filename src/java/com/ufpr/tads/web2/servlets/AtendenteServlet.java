/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.web2.servlets;

import com.google.gson.Gson;
import com.ufpr.tads.web2.beans.AtendenteBean;
import com.ufpr.tads.web2.facade.RegistrarClienteFacade;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.RegistrarClienteBean;
import com.ufpr.tads.web2.dto.RegistrarClienteDTO;
import com.ufpr.tads.web2.facade.AtendenteFacade;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AtendenteServlet", urlPatterns = {"/AtendenteServlet"})
public class AtendenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, Exception {

        LoginBean loginBean = (LoginBean) request.getSession().getAttribute("login");
        if (loginBean == null) {
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            String action = request.getParameter("action");
            if (null == action) {
                //TODO Implementar outras ações
                RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
                dispatcher.forward(request, response);
            } else {
                switch (action) {
                    case "formUpdate": {
                        AtendenteBean at = new AtendenteBean();
                        at.setId(Integer.parseInt(request.getParameter("id")));
                        AtendenteBean busca = AtendenteFacade.buscar(at);
                        request.setAttribute("user", busca);
                        request.setAttribute("route", "AtendenteServlet?action=update");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/atendenteedit.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case "delete": {

                        AtendenteBean at = new AtendenteBean();
                        at.setId(Integer.parseInt(request.getParameter("id")));
                        AtendenteFacade.remover(at);

                        response.sendRedirect("/PortalServlet");

                        break;
                    }
                    case "update": {
                        AtendenteBean at = new AtendenteBean();
                        at.setId(Integer.parseInt(request.getParameter("id")));
                        at.setNome(request.getParameter("nome"));
                        at.setCpf(request.getParameter("cpf"));
                        at.setEmail(request.getParameter("email"));
                        at.setEndereco(request.getParameter("endereco"));
                        at.setTelefone(request.getParameter("telefone"));

//                        Integer id = Integer.valueOf(request.getParameter("id"));;
//                        RegistrarClienteBean registro = registrarClienteFacade.buscarRegistro(id);
//                        request.setAttribute("action", "update");
//                        request.setAttribute("atendimento", registro);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("revisaratendimento.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }

                    case "new": {
                        AtendenteBean at = new AtendenteBean();
                        at.setId(Integer.parseInt(request.getParameter("id")));
                        at.setNome(request.getParameter("nome"));
                        at.setCpf(request.getParameter("cpf"));
                        at.setEmail(request.getParameter("email"));
                        at.setEndereco(request.getParameter("endereco"));
                        at.setTelefone(request.getParameter("telefone"));

//                        Integer id = Integer.valueOf(request.getParameter("id"));;
//                        RegistrarClienteBean registro = registrarClienteFacade.buscarRegistro(id);
//                        request.setAttribute("action", "update");
//                        request.setAttribute("atendimento", registro);
                        response.sendRedirect("/PortalServlet");

                        break;
                    }
                }
            }
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
        response.setContentType("text/html;charset=UTF-8");

        LoginBean loginBean = (LoginBean) request.getSession().getAttribute("login");
        if (loginBean == null) {
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            String action = request.getParameter("action");
            RegistrarClienteFacade registrarClienteFacade = new RegistrarClienteFacade();
            switch (action) {
                case "delete": {
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    String justificativa = request.getParameter("justificativa");
                    registrarClienteFacade.apagaRegistro(id, justificativa);
                    break;
                }
                case "update": {
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    String cpf = request.getParameter("cpf");
                    String dataHora = request.getParameter("dataHora");
                    String price = request.getParameter("price");
                    String justificativa = request.getParameter("justificativa");

                    //RegistrarClienteBean inputCliente = new RegistrarClienteBean(id, cpf, getDate(dataHora), getValor(price));
                    //inputCliente.setJustificativa(justificativa);

                    //registrarClienteFacade.atualizaRegistro(inputCliente);
                    break;
                }
                case "insert": {
                    String cpf = request.getParameter("cpf");
                    String dataHora = request.getParameter("dataHora");
                    String price = request.getParameter("price");

                    //RegistrarClienteBean inputCliente = new RegistrarClienteBean(null, cpf, getDate(dataHora), getValor(price));
                    //registrarClienteFacade.registrarAtendimento(inputCliente);
                }
            }

            response.sendRedirect("portal.jsp");
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
