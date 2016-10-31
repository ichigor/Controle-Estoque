package controlador;

import dao.UnidadeDAO;
import java.util.List;
import modelo.Unidade;

public class UnidadeController {
   
    public int incluir (String desc){
        Unidade unidade = new Unidade();
        unidade.setDescricao(desc);
        int erro = new UnidadeDAO().inserir(unidade);
        return erro;
    }
    
     public int alterar (int id, String desc) {
        
        Unidade unidade = new Unidade();
        unidade.setId(id);
        unidade.setDescricao(desc);
        int erro = new UnidadeDAO().alterar(unidade);
        return erro;
    }
     
    public int excluir (int id){
        Unidade unidade = new Unidade();
        unidade.setId(id);
        int erro = new UnidadeDAO().excluir(unidade);
        return erro;
    }
    
    public List<Unidade> listaUnidades() {
        UnidadeDAO u = new UnidadeDAO();
        return u.getLista();
    }
    
     public List<Unidade> getUnidadeDescricao(String desc){
        UnidadeDAO u = new UnidadeDAO();
        return u.getUnidadeDescricao(desc);
    }
     
    public Unidade getUnidadeId (int idUnidade){
        UnidadeDAO ud = new UnidadeDAO();
        return ud.getUnidadeId(idUnidade);
    }
    
}
