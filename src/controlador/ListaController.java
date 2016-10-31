/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ListaDao;
import java.util.List;
import modelo.Lista;

/**
 *
 * @author Thiago
 */
public class ListaController {
    
    
    public int incluir (int idOperacao, int idProduto, float quantidade){
        Lista lista = new Lista();
        lista.setIdOperacao(idOperacao);
        lista.setIdProduto(idProduto);
        lista.setQuantidade(quantidade);
        int erro = new ListaDao().inserir(lista); 
        return erro;
    }
    
    public int alterar (int idLista, int idOperacao, int idProduto, int quantidade){
        
        Lista lista = new Lista();
        lista.setIdLista(idLista);
        lista.setIdOperacao(idOperacao);
        lista.setIdProduto(idProduto);
        lista.setQuantidade(quantidade);
        int erro = new ListaDao().alterar(lista);
        return erro;
    }
    
    public int excluir (int idLista){
        Lista lista = new Lista();
        lista.setIdLista(idLista);
        int erro = new ListaDao().excluir(lista); 
        return erro;
    }
    
    public List<Lista> listaLista() {
        ListaDao listaDao = new ListaDao();
        return listaDao.getLista();
    }
    
    public Lista getListaId(int idLista){
        ListaDao listaDao = new ListaDao();
        return listaDao.getListaId(idLista);
    }
    
    public List<Lista> getListaIdOperacao(int idOperacao){
        ListaDao listaDao = new ListaDao();
        return listaDao.getListaIdOperacao(idOperacao);
    }
    
    
}
