/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semsalario.poo2.model;

/**
 *
 * @author jp
 */
public class User {

    private int id;
    private String name;
    private int cpf;
    private String email;
    private String senha;

    public User(String name, int cpf, String email, String senha) {
        this.id = 0;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public User(String email, String senha) {
        this.id = 0;
        this.name = null;
        this.cpf = null;
        this.email = email;
        this.senha = senha;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
