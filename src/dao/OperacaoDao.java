package dao;


import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.input.DataFormat;
import modelo.Operacao;
import modelo.Usuario;

public class OperacaoDao {

    private Connection con;

    public OperacaoDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }

    public int inserir(Operacao operacao) {
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "INSERT INTO Operacao (idUsuario, idFuncionario, observacao, dataOperacao, tipoEntSai)" + "VALUES (?,?,?,?,?)";
            pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, operacao.getIdUsuario());
            pstmt.setInt(2, operacao.getIdFuncionario());
            pstmt.setString(3, operacao.getObservacao());
            pstmt.setObject(4, operacao.getData());
            String T;
            T = String.valueOf(operacao.getTipo());
            pstmt.setString(5, T);
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

    public int alterar(Operacao operacao) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE Operacao SET idFuncionario=?, idUsuario=?, observacao=?, data=?, tipo=? WHERE idOperacao = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, operacao.getIdUsuario());
            pstm.setInt(2, operacao.getIdFuncionario());
            pstm.setString(3, operacao.getObservacao());
            pstm.setObject(4, operacao.getData());
            String T;
            T = String.valueOf(operacao.getTipo());
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

    public int excluir(Operacao operacao) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Operacao WHERE idOperacao = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, operacao.getIdOperacao());
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

    public List<Operacao> getLista() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            String sql = "SELECT idOperacao, idFuncionario, idUsuario, observacao, tipoEntSai FROM Operacao";
            //String sql = "SELECT * FROM Operacao";
            List<Operacao> listaOperacoes = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Operacao operacao = new Operacao();
                operacao.setIdOperacao(rs.getInt("idOperacao"));
                operacao.setIdFuncionario(rs.getInt("idFuncionario"));
                operacao.setIdUsuario(rs.getInt("idUsuario"));
                operacao.setObservacao(rs.getString("observacao"));
                //operacao.setData(rs.getDate("data"));
                operacao.setTipo(rs.getString("tipoEntSai").charAt(0));
                listaOperacoes.add(operacao);
            }
            rs.close();
            pstm.close();
            return listaOperacoes;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    public Operacao getOperacaoId(int id) {
        try{
            Operacao operacao = null;
            String sql = "SELECT * FROM OPERACAO WHERE idOperacao = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                operacao = new Operacao();
                operacao.setIdOperacao(rs.getInt("idOperacao"));
                operacao.setIdFuncionario(rs.getInt("idFuncionario"));
                operacao.setIdUsuario(rs.getInt("idUsuario"));
                operacao.setObservacao(rs.getString("observacao"));
                operacao.setData(rs.getDate("data"));
                String tipo = rs.getString("tipo");
                operacao.setTipo(tipo.charAt(0));
            }
            rs.close();
            pstm.close();
            return operacao;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    public int getBuscaUltimo (){
        int ultimo = 0;
        try{
            String sql = "SELECT MAX(idOperacao) FROM Operacao";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
               ultimo = rs.getInt("max(idOperacao)");
            }
            rs.close();
            pstm.close();
            return ultimo;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return ultimo;
        }
    }
    
    
    public String getBuscaTipo (int id){
        String tipo = null;
        try{
            String sql = "SELECT tipoEntSai FROM Operacao WHERE idOperacao = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
               tipo = rs.getString("tipoEntSai");
            }
            rs.close();
            pstm.close();
            return tipo;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return tipo;
        }
    }
    
     public List<Operacao> getOperacaoIdLista(String id) {
        int idOp = Integer.parseInt(id);
         try{
            String sql = "SELECT idOperacao, idFuncionario, idUsuario, observacao, tipoEntSai FROM Operacao WHERE idOperacao = ?";
            List<Operacao> listaOperacoes = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idOp);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Operacao operacao = new Operacao();
                operacao.setIdOperacao(rs.getInt("idOperacao"));
                operacao.setIdFuncionario(rs.getInt("idFuncionario"));
                operacao.setIdUsuario(rs.getInt("idUsuario"));
                operacao.setObservacao(rs.getString("observacao"));
                //operacao.setData(rs.getDate("data"));
                operacao.setTipo(rs.getString("tipoEntSai").charAt(0));
                listaOperacoes.add(operacao);
            }
            rs.close();
            pstm.close();
            return listaOperacoes;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
   
}
