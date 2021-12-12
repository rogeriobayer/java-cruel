/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.web2.servlets;

import com.google.gson.Gson;
import com.ufpr.tads.web2.facade.RegistrarClienteFacade;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.RegistrarClienteBean;
import com.ufpr.tads.web2.dto.RegistrarClienteDTO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drico
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {


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
        
        LoginBean loginBean = (LoginBean) request.getSession().getAttribute("login");
        if (loginBean == null) {
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            RegistrarClienteFacade registrarClienteFacade = new RegistrarClienteFacade();
            String action = request.getParameter("action");
            if (null == action) {
                //TODO Implementar outras ações
                RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
                dispatcher.forward(request, response);
            } else switch (action) {
                case "listar":
                    List<RegistrarClienteBean> registrosDia = registrarClienteFacade.buscaRegistrosDia();
                    // transforma o MAP em JSON
                    Gson gson = new Gson();
                    String json = gson.toJson(registrosDia.stream().map((RegistrarClienteBean reg) -> {
                        return new RegistrarClienteDTO(reg.getId(),
                                getDateComoString(reg.getDataHora()),
                                reg.getCpf(),
                                getValorMonetario(reg.getValor()));
                    }).collect(Collectors.toList()));
                    // retorna o JSON
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    break;
                case "delete":
                    {
                        Integer id = Integer.valueOf(request.getParameter("id"));
                        RegistrarClienteBean registro = registrarClienteFacade.buscarRegistro(id);
                        request.setAttribute("action", "delete");
                        request.setAttribute("atendimento", registro);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("revisaratendimento.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                case "update":
                    {
                        Integer id = Integer.valueOf(request.getParameter("id"));
                        RegistrarClienteBean registro = registrarClienteFacade.buscarRegistro(id);
                        request.setAttribute("action", "update");
                        request.setAttribute("atendimento", registro);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("revisaratendimento.jsp");
                        dispatcher.forward(request, response);
                        break;
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
                case "delete":
                    {
                        Integer id = Integer.valueOf(request.getParameter("id"));
                        String justificativa = request.getParameter("justificativa");
                        registrarClienteFacade.apagaRegistro(id, justificativa);
                        break;
                    }
                case "update":
                    {
                        Integer id = Integer.valueOf(request.getParameter("id"));
                        String cpf = request.getParameter("cpf");
                        String dataHora = request.getParameter("dataHora");
                        String price = request.getParameter("price");
                        String justificativa = request.getParameter("justificativa");

                        RegistrarClienteBean inputCliente = new RegistrarClienteBean(id, cpf, getDate(dataHora), getValor(price));
                        inputCliente.setJustificativa(justificativa);
                        
                        registrarClienteFacade.atualizaRegistro(inputCliente);
                        break;
                    }
                case "insert":
                {
                    String cpf = request.getParameter("cpf");
                    String dataHora = request.getParameter("dataHora");
                    String price = request.getParameter("price");

                    RegistrarClienteBean inputCliente = new RegistrarClienteBean(null, cpf, getDate(dataHora), getValor(price));
                    registrarClienteFacade.registrarAtendimento(inputCliente);
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

    private Date getDate(String dataComoTexto) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return dateFormatter.parse(dataComoTexto);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private Double getValor(String valorComoTexto){
        return Double.valueOf(valorComoTexto.replace(".", "").replace(",", "."));
    }
    
    private String getDateComoString(Date data) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.format(data);
    }
    
    private String getValorMonetario(Double valor){
        return ("R$ "+valor).replace('.', ',');
    }

}
