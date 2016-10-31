/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servidor;
import modelo.Usuario;

/**
 *
 * @author Igor
 */
public class BuscaDao {

    private Connection con;

    public BuscaDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }

    public int getServidorID(String nome) {
        try {
            String sql = "SELECT idUsuario FROM Usuario WHERE nomeCompleto = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();
            int teste = 0;
            while (rs.next()) {

                teste = rs.getInt("idUsuario");

            }
            rs.close();
            pstm.close();
            return teste;
        } catch (SQLException e) {
            System.out.println("Erro nro: " + e.getErrorCode());
            return 0;
        }
    }

    public int getLogin(String cpf, String senha) {
        try {
            String sql = "SELECT idUsuario FROM Usuario WHERE cpf = ? and senha = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            int teste = 0;
            while (rs.next()) {

                teste = rs.getInt("idUsuario");

            }
            rs.close();
            pstm.close();
            return teste;

        } catch (SQLException e) {
            System.out.println("Erro nro: " + e.getErrorCode());
            return 0;
        }
    }

    public String BuscaTipo(int id) {

        String t = "erro";

        try {
            String sql = "SELECT tipo FROM usuario, funcionario where Usuario.idUsuario = Funcionario.idUsuario and Usuario.idUsuario = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                t = rs.getString("tipo");
            }
            rs.close();
            pstm.close();
            

        } catch (SQLException e) {
            t = "erro";
        }

        if (t.equals("erro")) {

            try {
                String sql1 = "SELECT tipo FROM usuario, servidor where Usuario.idUsuario = Servidor.idUsuario and Usuario.idUsuario = ?";
                PreparedStatement pstm = con.prepareStatement(sql1);
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    t = rs.getString("tipo");
                }
                rs.close();
                pstm.close();

            } catch (SQLException e) {
                t = "erro";
            }

        } else {
            return t;
        }
        
        return t;
    }

}
