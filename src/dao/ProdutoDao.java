package dao;


import controlador.ServidorController;
import controlador.UnidadeController;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import modelo.Unidade;


public class ProdutoDao {

    private Connection con;

    public ProdutoDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }


    public int inserir(Produto produto) {
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "INSERT INTO Produto (idUnidade, nomeProduto, localizacao, qtdeMinima, qtdeAtual)" + "VALUES (?,?,?,?,?)";
            pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, produto.getUnidade().getId());
            pstmt.setString(2, produto.getNomeProduto());
            pstmt.setString(3, produto.getLocalizacao());
            pstmt.setFloat(4, produto.getQtdMin());
            pstmt.setFloat(5, produto.getQtdAtual());
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


    public int alterar(Produto produto) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE produto SET nomeProduto=?, localizacao=?, qtdeMinima=?, qtdeAtual=?, idUnidade=? WHERE idProduto = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setString(1, produto.getNomeProduto());
            pstm.setString(2, produto.getLocalizacao());
            pstm.setFloat(3, produto.getQtdMin());
            pstm.setFloat(4, produto.getQtdAtual());
            pstm.setInt(5, produto.getUnidade().getId());
            pstm.setInt(6, produto.getIdProduto());
            
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

    public int excluir(Produto produto) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Produto WHERE idPRoduto = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, produto.getIdProduto());
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

    public List<Produto> getLista() {
        try{
            String sql = "SELECT * FROM Produto";
            List<Produto> listaProduto = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                UnidadeController uc = new UnidadeController();
                Unidade unidade = (Unidade) uc.getUnidadeId(rs.getInt("IdUnidade"));
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setLocalizacao(rs.getString("localizacao"));
                produto.setQtdMin(rs.getFloat("qtdeMinima"));
                produto.setQtdAtual(rs.getFloat("qtdeAtual"));
                produto.setUnidade(unidade);
                listaProduto.add(produto);
            }
            rs.close();
            pstm.close();
            return listaProduto;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    
    public Produto getProdutoId(int id) {
        try{
            Produto produto = null;
            String sql = "SELECT * FROM Produto WHERE idProduto= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                UnidadeController uc = new UnidadeController();
                Unidade unidade = (Unidade) uc.getUnidadeId(rs.getInt("IdUnidade"));
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setLocalizacao(rs.getString("localizacao"));
                produto.setQtdMin(rs.getFloat("qtdeMinima"));
                produto.setQtdAtual(rs.getFloat("matricula"));
                produto.setUnidade(unidade);
            }
            rs.close();
            pstm.close();
            return produto;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }


    public List<Produto> getProdutoNome(String nome) {
        try{
            Produto produto = null;
            List<Produto> listaProduto = new ArrayList<>();
            String sql = "SELECT * FROM Produto WHERE nomeProduto Like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                UnidadeController uc = new UnidadeController();
                Unidade unidade = (Unidade) uc.getUnidadeId(rs.getInt("IdUnidade"));
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setLocalizacao(rs.getString("localizacao"));
                produto.setQtdMin(rs.getFloat("qtdeMinima"));
                produto.setQtdAtual(rs.getFloat("qtdeAtual"));
                produto.setUnidade(unidade);
                listaProduto.add(produto);
            }
            rs.close();
            pstm.close();
            return listaProduto;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    public List getProdutoLocalizacao(String localizacao) {
        try{
            Produto produto = null;
            List<Produto> listaProduto = new ArrayList<>();
            String sql = "SELECT * FROM Produto WHERE localizacao LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+localizacao+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                UnidadeController uc = new UnidadeController();
                Unidade unidade = (Unidade) uc.getUnidadeId(rs.getInt("IdUnidade"));
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setLocalizacao(rs.getString("localizacao"));
                produto.setQtdMin(rs.getFloat("qtdeMinima"));
                produto.setQtdAtual(rs.getFloat("qtdeAtual"));
                produto.setUnidade(unidade);
                listaProduto.add(produto);
            }
            rs.close();
            pstm.close();
            return listaProduto;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    public String getProdutoNomeId(int id) {
        try{
            Produto produto = null;
            String sql = "SELECT nomeProduto FROM Produto WHERE idProduto= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            String NOME = null;
            
            while(rs.next()){
                
                produto = new Produto();
                produto.setNomeProduto(rs.getString("nomeProduto"));
                NOME = produto.getNomeProduto();
            }
            rs.close();
            pstm.close();
            return NOME;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
    
    
    public int getAumentaQtd(int id, float qtd) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE produto SET qtdeAtual = qtdeAtual + ? WHERE idProduto = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setFloat(1, qtd);
            pstm.setInt(2,id);
                       
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
    
    public int getDiminuiQtd(int id, float qtd) {
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPDATE produto SET qtdeAtual = qtdeAtual - ? WHERE idProduto = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setFloat(1, qtd);
            pstm.setInt(2,id);
                       
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
    
    
    
}
