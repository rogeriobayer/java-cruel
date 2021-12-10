/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author anado
 */
import java.io.Serializable;

public class LoginBean implements Serializable {

    private int id;
    private String login;
    private String senha;
    private String cargo;

    public LoginBean() {
    }

    public LoginBean(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public LoginBean(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}

