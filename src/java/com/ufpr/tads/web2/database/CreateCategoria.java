/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.database;

import com.ufpr.tads.web2.dao.connections.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author anado
 */
public class CreateCategoria {
    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO categoria(categoria) VALUES "
                    + "('Professor'),"
                    + "('Servidor'),"
                    + "('Aluno'),"
                    + "('Externo')");

            System.out.println("Categorias criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Categorias.");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (query != null) {
                try {
                    query.close();
                    query = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
