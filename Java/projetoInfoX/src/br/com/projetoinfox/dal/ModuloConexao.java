/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoinfox.dal;
//para o java trabalhar com o sql

import java.sql.*;

/**
 *
 * @author Bruna Rossini
 */
public class ModuloConexao {

    // método responsável por estabelecer a conexão com o banco 
    // Connection é um framework do pacote sql
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // chamando o driver
        String driver = "com.mysql.jdbc.Driver";
        // armazenando informações do banco
        String url = "jdbc:mysql://localhost:3310/dbinfox";
        String user = "root";
        String password = "";
        // estabelencendo a conexando com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            
            //System.out.println(e);
            return null;
        }
    }

}
