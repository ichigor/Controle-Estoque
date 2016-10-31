package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Unidade;

public class UnidadeDAO {
    
    private Connection con;

    public UnidadeDAO() {
        con = (Connection) ConnectionFactory.getConnection();
    }
    
    public int inserir(Unidade unidade) {
           
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "INSERT INTO Unidade (descricao)" + "VALUES (?)";
            pstmt = con.prepareStatement(sql1);
            pstmt.setString(1, unidade.getDescricao());
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
    
    public int alterar(Unidade unidade) {
        
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE unidade SET descricao=? WHERE idUnidade = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setString(1, unidade.getDescricao());
            pstm.setInt(2, unidade.getId());
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
    
    public int excluir(Unidade unidade) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Unidade WHERE idUnidade = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, unidade.getId());
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
    
    
    public List<Unidade> getLista() {
        try{
            String sql = "SELECT * FROM Unidade";
            List<Unidade> listaUnidades = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Unidade unidade = new Unidade();
                unidade.setId(rs.getInt("idUnidade"));
                unidade.setDescricao(rs.getString("descricao"));
                listaUnidades.add(unidade);
            }
            rs.close();
            pstm.close();
            return listaUnidades;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
     
    public Unidade getUnidadeId(int id) {
        try{
            Unidade unidade = null;
            String sql = "SELECT * FROM Unidade WHERE idUnidade= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                unidade = new Unidade();
                unidade.setId(rs.getInt("idUnidade"));
                unidade.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            pstm.close();
            return unidade;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    public List getUnidadeDescricao(String desc) {
        try{
            Unidade unidade = null;
            List<Unidade> listaUnidades = new ArrayList<>();
            String sql = "SELECT * FROM Unidade WHERE descricao LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+desc+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                unidade = new Unidade();
                unidade.setId(rs.getInt("idUnidade"));
                unidade.setDescricao(rs.getString("descricao"));
                listaUnidades.add(unidade);
            }
            rs.close();
            pstm.close();
            return listaUnidades;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    
}
