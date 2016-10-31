package controlador;

import dao.BolsistaDao;
import dao.ServidorDao;
import java.util.List;
import modelo.Bolsista;
import modelo.Servidor;
import modelo.Usuario;

public class BolsistaController {
    public int incluir (String nomeCompleto, String cpf, String senha, String matricula, Servidor servidor){
        Bolsista bolsista = new Bolsista();
        bolsista.setNomeCompleto(nomeCompleto);
        bolsista.setCpf(cpf);
        bolsista.setSenha(senha);
        bolsista.setMatricula(matricula);
        bolsista.setServidor(servidor);
        int erro = new BolsistaDao().inserir(bolsista);
        return erro;
    }
    
    public int alterar (int idBolsista, String nomeCompleto, String cpf, String senha, String matricula, Servidor servidor){
        
        Bolsista bolsista = new Bolsista();
        bolsista.setIdBolsista(idBolsista);
        bolsista.setNomeCompleto(nomeCompleto);
        bolsista.setCpf(cpf);
        bolsista.setSenha(senha);
        bolsista.setMatricula(matricula);
        bolsista.setServidor(servidor);
        int erro = new BolsistaDao().alterar(bolsista);
        return erro;
    }
    public int excluir (int idBolsista){
        Bolsista bolsista = new Bolsista();
        bolsista.setIdBolsista(idBolsista);
        int erro = new BolsistaDao().excluir(bolsista);
        return erro;
    }
    
    public List<Bolsista> listaBolsista() {
        BolsistaDao bolsistaDao = new BolsistaDao();
        return bolsistaDao.getLista();
    }
    public List<Bolsista> getUsuarioNome(String nome){
        BolsistaDao bolsistaDao = new BolsistaDao();
        return bolsistaDao.getUsuarioNome(nome);
    }
    public Usuario geUsuarioId(int idBolsista){
        BolsistaDao bolsistaDao = new BolsistaDao();
        return bolsistaDao.getUsuarioId(idBolsista);
    }
    public List<Bolsista> getUsuarioCpf(String cpf){
        BolsistaDao bolsistaDao = new BolsistaDao();
        return bolsistaDao.getUsuarioCpf(cpf);
    }
    public List<Bolsista> getBolsistaMatricula(String matricula){
        BolsistaDao bolsistaDao = new BolsistaDao();
        return bolsistaDao.getBolsistaMatricula(matricula);
    }
    
}
