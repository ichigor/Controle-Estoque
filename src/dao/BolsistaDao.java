package dao;


import controlador.ServidorController;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Bolsista;
import modelo.Servidor;
import modelo.Usuario;

public class BolsistaDao implements UsuarioDao {

    private Connection con;

    public BolsistaDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }

    @Override
    public int inserir(Usuario usuario) {
        int ai = 0;
        Bolsista bolsista = (Bolsista) usuario;
        Object parUsuario[] = {bolsista.getNomeCompleto(), bolsista.getCpf(), bolsista.getSenha()};
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES " + "WHERE TABLE_NAME = 'Usuario' AND TABLE_SCHEMA='estoque'";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ai = rs.getInt("AUTO_INCREMENT");
            }
            String sql1 = "INSERT INTO Usuario (nomeCompleto,cpf,senha) VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql1);
            for (int i = 0; i < parUsuario.length; i++) {
                pstmt.setObject(i + 1, parUsuario[i]);
            }
            pstmt.execute();
            Object parBolsista[] = {ai, bolsista.getMatricula(), bolsista.getServidor().getIdServidor()};
            String sql2 = "INSERT INTO Bolsista (idUsuario,matricula,idServidor)" + "VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql2);
            for (int i = 0; i < parBolsista.length; i++) {
                pstmt.setObject(i + 1, parBolsista[i]);
            }
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

    @Override
    public int alterar(Usuario usuario) {
        Bolsista bolsista = (Bolsista) usuario;
        Object parUsuario[] = {bolsista.getNomeCompleto(), bolsista.getCpf(), bolsista.getSenha(), bolsista.getIdBolsista()};
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE Usuario SET nomeCompleto=?, cpf=?, senha=? WHERE idUsuario=?";
            pstm = con.prepareStatement(sql1);
            for (int i = 0; i < parUsuario.length; i++) {
                pstm.setObject(i + 1, parUsuario[i]);
            }            
            pstm.execute();
            Object parBolsista[] = {bolsista.getMatricula(), bolsista.getServidor().getIdServidor(), bolsista.getIdBolsista()};
            String sql2 = "UPDATE Bolsista SET matricula=?, idServidor=? WHERE idUsuario=?";
            pstm = con.prepareStatement(sql2);
            for (int i = 0; i < parBolsista.length; i++) {                
                    pstm.setObject(i + 1, parBolsista[i]);                
            }
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

    @Override
    public int excluir(Usuario usuario) {
        Bolsista bolsista = (Bolsista) usuario;
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Usuario WHERE idUsuario = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, bolsista.getIdBolsista());
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

    @Override
    public List<Bolsista> getLista() {
        try{
            String sql = "SELECT * FROM Usuario U INNER JOIN Bolsista B ON"+"(U.idUsuario = B.idUsuario)";
            List<Bolsista> listaBolsista = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ServidorController sc = new ServidorController();
                Servidor servidor = (Servidor) sc.getUsuarioId(rs.getInt("IdServidor"));
                Bolsista bolsista = new Bolsista();
                bolsista.setIdBolsista(rs.getInt("idUsuario"));
                bolsista.setNomeCompleto(rs.getString("nomeCompleto"));
                bolsista.setCpf(rs.getString("cpf"));
                bolsista.setSenha(rs.getString("senha"));
                bolsista.setMatricula(rs.getString("matricula"));
                bolsista.setServidor(servidor);
                listaBolsista.add(bolsista);
            }
            rs.close();
            pstm.close();
            return listaBolsista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    @Override
    public Usuario getUsuarioId(int id) {
        try{
            Bolsista bolsista = null;
            String sql = "SELECT * FROM Usuario U INNER JOIN Bolsista B ON"+"(U.idUsuario = B.idUsuario) WHERE U.idUsuario= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ServidorController sc = new ServidorController();
                Servidor servidor = (Servidor) sc.getUsuarioId(rs.getInt("IdServidor"));
                bolsista = new Bolsista();
                bolsista.setIdBolsista(rs.getInt("idUsuario"));
                bolsista.setNomeCompleto(rs.getString("nomeCompleto"));
                bolsista.setCpf(rs.getString("cpf"));
                bolsista.setSenha("senha");
                bolsista.setMatricula("matricula");
                bolsista.setServidor(servidor);
            }
            rs.close();
            pstm.close();
            return bolsista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    @Override
    public List getUsuarioNome(String nome) {
        try{
            Bolsista bolsista = null;
            List<Bolsista> listaBolsista = new ArrayList<>();
            String sql = "SELECT * FROM Usuario U INNER JOIN Bolsista B ON"+"(U.idUsuario = B.idUsuario) WHERE U.nomeCompleto LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ServidorController sc = new ServidorController();
                Servidor servidor = (Servidor) sc.getUsuarioId(rs.getInt("IdServidor"));
                bolsista = new Bolsista();
                bolsista.setIdBolsista(rs.getInt("idUsuario"));
                bolsista.setNomeCompleto(rs.getString("nomeCompleto"));
                bolsista.setCpf(rs.getString("cpf"));
                bolsista.setSenha(rs.getString("senha"));
                bolsista.setMatricula(rs.getString("matricula"));
                bolsista.setServidor(servidor);
                listaBolsista.add(bolsista);
            }
            rs.close();
            pstm.close();
            return listaBolsista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    public List<Bolsista> getUsuarioCpf(String cpf) {
        try{
            Bolsista bolsista = null;
            List<Bolsista> listaBolsista = new ArrayList<>();
            String sql = "SELECT * FROM Usuario U INNER JOIN Bolsista B ON"+"(U.idUsuario = B.idUsuario) WHERE U.cpf LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ServidorController sc = new ServidorController();
                Servidor servidor = (Servidor) sc.getUsuarioId(rs.getInt("IdServidor"));
                bolsista = new Bolsista();
                bolsista.setIdBolsista(rs.getInt("idUsuario"));
                bolsista.setNomeCompleto(rs.getString("nomeCompleto"));
                bolsista.setCpf(rs.getString("cpf"));
                bolsista.setSenha(rs.getString("senha"));
                bolsista.setMatricula(rs.getString("matricula"));
                bolsista.setServidor(servidor);
                listaBolsista.add(bolsista);
            }
            rs.close();
            pstm.close();
            return listaBolsista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    public List<Bolsista> getBolsistaMatricula(String matricula) {
        try{
            Bolsista bolsista = null;
            List<Bolsista> listaBolsista = new ArrayList<>();
            String sql = "SELECT * FROM Usuario U INNER JOIN Bolsista B ON"+"(U.idUsuario = B.idUsuario) WHERE B.matricula LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,matricula+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ServidorController sc = new ServidorController();
                Servidor servidor = (Servidor) sc.getUsuarioId(rs.getInt("IdServidor"));
                bolsista = new Bolsista();
                bolsista.setIdBolsista(rs.getInt("idUsuario"));
                bolsista.setNomeCompleto(rs.getString("nomeCompleto"));
                bolsista.setCpf(rs.getString("cpf"));
                bolsista.setSenha(rs.getString("senha"));
                bolsista.setMatricula(rs.getString("matricula"));
                bolsista.setServidor(servidor);
                listaBolsista.add(bolsista);
            }
            rs.close();
            pstm.close();
            return listaBolsista;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
}
