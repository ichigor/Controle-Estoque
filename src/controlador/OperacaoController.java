package controlador;

import dao.OperacaoDao;
import java.util.Date;
import java.util.List;
import modelo.Operacao;
import modelo.Operacao;
import modelo.Usuario;

public class OperacaoController {
    public int incluir (int idFuncionario, int idUsuario, String obs, Date data, char tipo){
        Operacao operacao = new Operacao();
        operacao.setIdFuncionario(idFuncionario);
        operacao.setIdUsuario(idUsuario);
        operacao.setObservacao(obs);
        operacao.setData(data);
        operacao.setTipo(tipo);
        int erro = new OperacaoDao().inserir(operacao); 
        return erro;
    }
    
    public int alterar (int idOperacao, int idFuncionario, int idUsuario, String obs, Date data, char tipo){
        
        Operacao operacao = new Operacao();
        operacao.setIdOperacao(idOperacao);
        operacao.setIdFuncionario(idFuncionario);
        operacao.setIdUsuario(idUsuario);
        operacao.setObservacao(obs);
        operacao.setData(data);
        operacao.setTipo(tipo);
        int erro = new OperacaoDao().alterar(operacao);
        return erro;
    }
    
    public int excluir (int idOperacao){
        Operacao operacao = new Operacao();
        operacao.setIdOperacao(idOperacao);
        int erro = new OperacaoDao().excluir(operacao); 
        return erro;
    }
    
    public List<Operacao> listaOperacoes() {
        OperacaoDao operacaoDao = new OperacaoDao();
        return operacaoDao.getLista();
    }
        
    public Operacao getOperacaoId(int idOperacao){
        OperacaoDao operacaoDao = new OperacaoDao();
        return operacaoDao.getOperacaoId(idOperacao);
    }
    
    public int buscaUltimo(){
        OperacaoDao dao = new OperacaoDao();
        return dao.getBuscaUltimo();
    }
    
    public String buscaTipo(int qtd){
        OperacaoDao dao = new OperacaoDao();
        return dao.getBuscaTipo(qtd);
    }
    
    public List<Operacao> getOperacaoIdLista(String id) {
        OperacaoDao operacaoDao = new OperacaoDao();
        return operacaoDao.getOperacaoIdLista(id);
    }
    
}
