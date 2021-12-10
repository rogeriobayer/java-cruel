/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.acesso;

import java.sql.Connection;

/**
 *
 * @author anado
 */
public class AlunoDAO {
    
    private static final String QUERY_BUSCAR = "SELECT id, CPF, nome, email, data, endereco, telefone, curso, ano_ingresso, grr FROM cadastro_aluno WHERE id = ?;";
    private static final String QUERY_BUSCAR_POR_ORDEM = "SELECT id FROM categoria WHERE categoria = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, CPF, nome, email, data, endereco, telefone, curso, ano_ingresso, grr FROM cadastro_aluno;";
    private static final String QUERY_INSERIR = "INSERT INTO cadastro_aluno(CPF, nome, email, data, endereco, telefone, curso, ano_ingresso, grr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cadastro_aluno WHERE id = ?;";
    private static final String QUERY_EDITAR = "";
    
    private Connection con = null;

    public AlunoDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }
}
