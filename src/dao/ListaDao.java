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
import modelo.Lista;
import modelo.Operacao;


public class ListaDao {
    
    private Connection con;

    public ListaDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }

    public int inserir(Lista lista) {
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "INSERT INTO Lista (idOperacao, idProduto, quantidade)" + "VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, lista.getIdOperacao());
            pstmt.setInt(2, lista.getIdProduto());
            pstmt.setFloat(3, lista.getQuantidade());
            pstmt.execute();
            con.commit();
            return -1;
        } catch (SQLException e) {
            try {
                con.rollback();
                return e.getErrorCode();
            } catch (SQLException ex) {
                return ex.getErrorCode();
            }
        } finally {
            try {
                pstmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    public int alterar(Lista lista) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE Lista SET idOperacao=?, idProduto=?, quantidade=? WHERE idLista = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, lista.getIdOperacao());
            pstm.setInt(2, lista.getIdProduto());
            pstm.setFloat(3, lista.getQuantidade());
            pstm.setInt(4, lista.getIdLista());
            pstm.execute();
            con.commit();
            return -1;
        } catch (SQLException e) {
            try {
                con.rollback();
                return e.getErrorCode();
            } catch (SQLException ex) {
                return ex.getErrorCode();
            }
        } finally {
            try {
                pstm.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    public int excluir(Lista lista) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Lista WHERE idLista = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, lista.getIdLista());
            pstm.execute();
            con.commit();
            return -1;
        } catch (SQLException e) {
            try {
                con.rollback();
                return e.getErrorCode();
            } catch (SQLException ex) {
                return ex.getErrorCode();
            }
        } finally {
            try {
                pstm.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    
    public List<Lista> getLista() {
        try{
            String sql = "SELECT * FROM Lista";
            List<Lista> listaLista = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Lista lista = new Lista();
                lista.setIdLista(rs.getInt("idLista"));
                lista.setIdOperacao(rs.getInt("idOperacao"));
                lista.setIdProduto(rs.getInt("idProduto"));
                lista.setQuantidade(rs.getFloat("quantidade"));
                listaLista.add(lista);
            }
            rs.close();
            pstm.close();
            return listaLista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    public List<Lista> getListaIdOperacao(int idOperacao) {
        
        PreparedStatement pstm = null;
        try{
            String sql = "SELECT * FROM Lista WHERE idOperacao=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idOperacao);
            List<Lista> listaLista = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Lista lista = new Lista();
                lista.setIdLista(rs.getInt("idLista"));
                lista.setIdOperacao(rs.getInt("idOperacao"));
                lista.setIdProduto(rs.getInt("idProduto"));
                lista.setQuantidade(rs.getFloat("quantidade"));
                listaLista.add(lista);
            }
            rs.close();
            pstm.close();
            return listaLista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    public Lista getListaId(int id) {
        try{
            Lista lista = null;
            String sql = "SELECT * FROM LISTA WHERE idLista = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                lista = new Lista();
                lista.setIdLista(rs.getInt("idLista"));
                lista.setIdOperacao(rs.getInt("idOperacao"));
                lista.setIdProduto(rs.getInt("idProduto"));
                lista.setQuantidade(rs.getFloat("quantidade"));
            }
            rs.close();
            pstm.close();
            return lista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    
}
