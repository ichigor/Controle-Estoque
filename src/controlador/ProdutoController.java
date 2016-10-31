package controlador;

import dao.ProdutoDao;
import java.util.List;
import modelo.Produto;
import modelo.Unidade;

public class ProdutoController {
    
    public int incluir (String nome, String localizacao, float qtdMin, float qtdAtual, Unidade unidade){
        Produto produto = new Produto();
        produto.setNomeProduto(nome);
        produto.setLocalizacao(localizacao);
        produto.setQtdMin(qtdMin);
        produto.setQtdAtual(qtdAtual);
        produto.setUnidade(unidade);
        int erro = new ProdutoDao().inserir(produto);
        return erro;
    }
    
    public int alterar (int id, String nome, String localizacao, float qtdMin, float qtdAtual, Unidade unidade){
        
        Produto produto = new Produto();
        produto.setIdProduto(id);
        produto.setNomeProduto(nome);
        produto.setLocalizacao(localizacao);
        produto.setQtdMin(qtdMin);
        produto.setQtdAtual(qtdAtual);
        produto.setUnidade(unidade);
        int erro = new ProdutoDao().alterar(produto);
        return erro;
    }
    public int excluir (int idProduto){
        Produto produto = new Produto();
        produto.setIdProduto(idProduto);
        int erro = new ProdutoDao().excluir(produto);
        return erro;
    }
    
    public List<Produto> listaProduto() {
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.getLista();
    }
    
    public List<Produto> getProdutoNome(String nomeProduto){
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.getProdutoNome(nomeProduto);
    }
    
    public Produto geProdutoId(int idProduto){
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.getProdutoId(idProduto);
    }
    
    public List<Produto> getProdutoLocalizacao(String localizacao){
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.getProdutoLocalizacao(localizacao);
    }
    
    public String geProdutoNomeID(int idProduto){
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.getProdutoNomeId(idProduto);
    }
    
    public int aumentaQtd (int id, float qtd){
        ProdutoDao dao = new ProdutoDao();
        return dao.getAumentaQtd(id, qtd);
    }
    
    public int diminuiQtd (int id, float qtd){
        ProdutoDao dao = new ProdutoDao();
        return dao.getDiminuiQtd(id, qtd);
    }
    
    
    
    
    
}
