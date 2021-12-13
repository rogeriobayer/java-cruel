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
public class CreateTable {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            //Drop and recreate schema
            query.executeUpdate("DROP SCHEMA IF EXISTS public CASCADE;");
            query.executeUpdate("CREATE SCHEMA public;");

            //Giving permissions
            query.executeUpdate("GRANT ALL ON SCHEMA public TO postgres;");
            query.executeUpdate("GRANT ALL ON SCHEMA public TO public;");

            //Creating New Tables
            query.executeUpdate("CREATE TABLE IF NOT EXISTS login("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "cargo varchar(255) NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS categoria ("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "categoria varchar(50) UNIQUE);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_aluno ("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255) NOT NULL, "
                    + "telefone varchar(11) NOT NULL, "
                    + "curso varchar(255) NOT NULL, "
                    + "ano_ingresso int NOT NULL, "
                    + "grr varchar(11) NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_professor ("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255) NOT NULL, "
                    + "telefone varchar(11) NOT NULL, "
                    + "depto varchar(255) NOT NULL, "
                    + "area_estudo varchar(255) NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_servidor ("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255) NOT NULL, "
                    + "telefone varchar(11) NOT NULL, "
                    + "unidade varchar(255) NOT NULL, "
                    + "data_ingresso date NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_externo ("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255)NOT NULL, "
                    + "telefone varchar(11)NOT NULL, "
                    + "observacao varchar(255));");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_atendente ("
                    + "id SERIAL UNIQUE PRIMARY KEY,"
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "telefone varchar(11) NOT NULL, "
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255) NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_nutri ("
                    + "id SERIAL UNIQUE PRIMARY KEY,"
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "crn varchar(255) NOT NULL, "
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255) NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cadastro_gerente ("
                    + "id SERIAL UNIQUE PRIMARY KEY,"
                    + "login varchar(50) UNIQUE NOT NULL,"
                    + "senha varchar(255) NOT NULL, "
                    + "CPF varchar(11) UNIQUE NOT NULL, "
                    + "nome varchar(255) NOT NULL,"
                    + "email varchar(255) UNIQUE NOT NULL, "
                    + "data date NOT NULL, "
                    + "endereco varchar(255) NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS registrar_cliente ("
                    + "id SERIAL UNIQUE PRIMARY KEY,  "
                    + "data_hora timestamp,  "
                    + "CPF varchar(11),  "
                    + "valor double precision, "
                    + "categoria varchar(50), "
                    + "foreign key (categoria) references categoria(categoria))");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS tipo_ingrediente ("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "nome varchar(50) UNIQUE);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS ingrediente("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "nome varchar(50) UNIQUE NOT NULL,"
                    + "tipo int NOT NULL, "
                    + "descricao varchar(255) NOT NULL, "
                    + "foreign key (tipo) references tipo_ingrediente(id));");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS cardapio("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "data date NOT NULL);");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS refeicao("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "turno varchar(50) NOT NULL,"
                    + "id_cardapio int NOT NULL, "
                    + "foreign key (id_cardapio) references cardapio(id));");
            query.executeUpdate("CREATE TABLE IF NOT EXISTS refeicao_ingrediente("
                    + "id SERIAL UNIQUE PRIMARY KEY, "
                    + "quantidade int not null, "
                    + "id_refeicao int NOT NULL, "
                    + "id_ingrediente int NOT NULL, "
                    + "foreign key (id_refeicao) references refeicao(id),"
                    + "foreign key (id_ingrediente) references ingrediente(id));");
            System.out.println("Tabelas criadas com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar tabelas.");
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
