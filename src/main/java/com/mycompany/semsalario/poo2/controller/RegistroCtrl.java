/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semsalario.poo2.controller;

/**
 *
 * @author jp
 */

import com.mycompany.semsalario.poo2.model.Registro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroCtrl {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/sem_salario_poo2";
    static String user = "jota";
    static String senha = "";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //faz o crud para o mysql server
    public void inserir(Registro registro) {
        String sql = "INSERT INTO registro (name, date, time, type, value, description) VALUES(?,?,?,?,?,?)";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            ps = con.prepareStatement(sql);
            System.out.println("inserindo dados...");
            
            ps.setString(1, registro.getName());
            ps.setString(2, registro.getDate().toString());
            ps.setString(3, registro.getTime().toString());
            ps.setString(4, registro.getType());
            ps.setFloat(5, registro.getValue());
            ps.setString(6, registro.getDescription());
            
            ps.execute();
            System.out.println("dados inseridos com sucesso");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("registro inserido com sucesso!");
    }

    public List<Registro> ler() {
        String sql = "SELECT * FROM registro";
        List<Registro> registros = new ArrayList<>();

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            System.out.println("lendo registros...");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Registro registro = new Registro(
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("type"),
                        rs.getFloat("value"),
                        rs.getString("description")
                );
                registros.add(registro);
            }
            
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return registros;
    }

    public void atualizar(Registro registro) {
        String sql = "UPDATE registro SET name = ?, date = ?, time = ?, type = ?, value = ?, description = ?, WHERE id = ?";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            ps = con.prepareStatement(sql);
            System.out.println("atualizando registro...");
            
            ps.setString(1, registro.getName());
            ps.setString(2, registro.getDate());
            ps.setString(3, registro.getTime());
            ps.setString(4, registro.getType());
            ps.setFloat(5, registro.getValue());
            ps.setString(6, registro.getDescription());
            ps.setInt(7, registro.getId());
            
            ps.execute();
            System.out.println("dados atualizados com sucesso");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("registro atualizado com sucesso");
    }

    public void deletar(int id) {
        String sql = "DELETE from registro WHERE id = ?";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            ps = con.prepareStatement(sql);
            System.out.println("deletando registro...");
            
            ps.setInt(1, id);
            ps.execute();
            
            System.out.println("dados excluidos com sucesso");

            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("registro excluido com sucesso");
    }
}
