package dao;


import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;
import modelo.Usuario;

public class FuncionarioDao implements UsuarioDao {

    private Connection con;

    public FuncionarioDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }

    @Override
    public int inserir(Usuario usuario) {
        int ai = 0;
        Funcionario funcionario = (Funcionario) usuario;
        Object parUsuario[] = {funcionario.getNomeCompleto(), funcionario.getCpf(), funcionario.getSenha()};
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
            Object parFuncionario[] = {ai, funcionario.getEmail(), funcionario.getTipo()};
            String sql2 = "INSERT INTO Funcionario (idUsuario,email,tipo)" + "VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql2);
            for (int i = 0; i < parFuncionario.length-1; i++) {
                pstmt.setObject(i + 1, parFuncionario[i]);
            }
            
            //arrumar botao radio com if e else e colocar linha de baixo dentro
            
            pstmt.setString(3, String.valueOf(parFuncionario[2]));
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
        Funcionario funcionario = (Funcionario) usuario;
        Object parUsuario[] = {funcionario.getNomeCompleto(), funcionario.getCpf(), funcionario.getSenha(), funcionario.getIdFuncionario()};
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE Usuario SET nomeCompleto=?, cpf=?, senha=? WHERE idUsuario=?";
            pstm = con.prepareStatement(sql1);
            for (int i = 0; i < parUsuario.length; i++) {
                pstm.setObject(i + 1, parUsuario[i]);
            }            
            pstm.execute();
            Object parFuncionario[] = {funcionario.getEmail(), funcionario.getTipo(), funcionario.getIdFuncionario()};
            String sql2 = "UPDATE Servidor SET email=?, tipo=? WHERE idUsuario=?";
            pstm = con.prepareStatement(sql2);
            for (int i = 0; i < parFuncionario.length; i++) {
                if(i==1){
                    pstm.setString(2, String.valueOf(parFuncionario[2]));
                }else{
                    pstm.setObject(i + 1, parFuncionario[i]);
                }
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
        Funcionario funcionario = (Funcionario) usuario;
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Usuario WHERE idUsuario = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, funcionario.getIdFuncionario());
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
    public List<Funcionario> getLista() {
        try{
            String sql = "SELECT * FROM Usuario U INNER JOIN Funcionario F ON (U.idUsuario = F.idUsuario)";
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                int teste = rs.getInt("idUsuario");
                funcionario.setIdFuncionario(teste);
                //funcionario.setIdFuncionario(rs.getInt("idUsuario"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setEmail(rs.getString("email"));
                String tipo = rs.getString("tipo");
                funcionario.setTipo(tipo.charAt(0));
                listaFuncionarios.add(funcionario);
            }
            rs.close();
            pstm.close();
            return listaFuncionarios;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    @Override
    public Usuario getUsuarioId(int id) {
        try{
            Funcionario funcionario = null;
            String sql = "SELECT * FROM Usuario U INNER JOIN Funcionario F ON"+"(U.idUsuario = F.idUsuario) WHERE U.idUsuario= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idUsuario"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha("senha");
                funcionario.setEmail("email");
                String tipo = rs.getString("tipo");
                funcionario.setTipo(tipo.charAt(0));
            }
            rs.close();
            pstm.close();
            return funcionario;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    @Override
    public List getUsuarioNome(String nome) {
        try{
            Funcionario funcionario = null;
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            String sql = "SELECT * FROM Usuario U INNER JOIN Funcionario F ON"+"(U.idUsuario = F.idUsuario) WHERE U.nomeCompleto LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idUsuario"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setEmail(rs.getString("email"));
                String tipo = rs.getString("tipo");
                funcionario.setTipo(tipo.charAt(0));
                listaFuncionarios.add(funcionario);
            }
            rs.close();
            pstm.close();
            return listaFuncionarios;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    public List<Funcionario> getUsuarioCpf(String cpf) {
        try{
            Funcionario funcionario = null;
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            String sql = "SELECT * FROM Usuario U INNER JOIN Funcionario F ON"+"(U.idUsuario = F.idUsuario) WHERE U.cpf LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idUsuario"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setEmail(rs.getString("email"));
                String tipo = rs.getString("tipo");
                funcionario.setTipo(tipo.charAt(0));
                listaFuncionarios.add(funcionario);
            }
            rs.close();
            pstm.close();
            return listaFuncionarios;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
}