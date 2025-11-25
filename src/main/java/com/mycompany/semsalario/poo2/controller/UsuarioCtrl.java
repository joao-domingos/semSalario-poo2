/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semsalario.poo2.controller;

/**
 *
 * @author jp
 */

import com.mycompany.semsalario.poo2.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCtrl {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/sem_salario_poo2";
    static String user = "jota";
    static String senha = "";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (name, cpf, email, senha) VALUES (?,?,?,?)";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            ps = con.prepareStatement(sql);
            System.out.println("inserindo dados...");
            
            ps.setString(1, usuario.getName());
            ps.setInt(2, usuario.getCpf());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            
            ps.execute();
            System.out.println("dados inseridos com sucesso");
            
            ps.close();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("usuario inserido com sucesso!");
    }
    
    public List<Usuario> ler() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            System.out.println("lendo usuarios...");
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("name"),
                        rs.getInt("cpf"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                usuarios.add(usuario);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarios;
    }
    
        public void atualizar(Usuario usuario) {
        String sql = "UPDATE registro SET name = ?, cpf = ?, email = ?, senha = ?, WHERE id = ?";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            ps = con.prepareStatement(sql);
            System.out.println("atualizando usuario...");
            
            ps.setString(1, usuario.getName());
            ps.setInt(2, usuario.getCpf());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setInt(5, usuario.getId());
            
            ps.execute();
            System.out.println("dados atualizados com sucesso");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("usuario atualizado com sucesso");
    }

    public void deletar(int id) {
        String sql = "DELETE from registros WHERE id = ?";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            ps = con.prepareStatement(sql);
            System.out.println("deletando usuario...");
            
            ps.setInt(1, id);
            ps.execute();
            
            System.out.println("dados excluidos com sucesso");

            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("usuario excluido com sucesso");
    }
}
