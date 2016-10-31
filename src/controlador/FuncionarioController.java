package controlador;

import dao.FuncionarioDao;
import java.util.List;
import modelo.Funcionario;
import modelo.Usuario;

public class FuncionarioController {
    public int incluir (String nomeCompleto, String cpf, String senha, String email, char tipo){
        Funcionario funcionario = new Funcionario();
        funcionario.setNomeCompleto(nomeCompleto);
        funcionario.setCpf(cpf);
        funcionario.setSenha(senha);
        funcionario.setEmail(email);
        funcionario.setTipo(tipo);
        int erro = new FuncionarioDao().inserir(funcionario);
        return erro;
    }
    
    public int alterar (int idFuncionario, String nomeCompleto, String cpf, String senha, String email, char tipo){
        
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(idFuncionario);
        funcionario.setNomeCompleto(nomeCompleto);
        funcionario.setCpf(cpf);
        funcionario.setSenha(senha);
        funcionario.setEmail(email);
        funcionario.setTipo(tipo);
        int erro = new FuncionarioDao().alterar(funcionario);
        return erro;
    }
    public int excluir (int idFuncionario){
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(idFuncionario);
        int erro = new FuncionarioDao().excluir(funcionario);
        return erro;
        
    }
    public List<Funcionario> listaFuncionario() {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getLista();
    }
    public List<Funcionario> getUsuarioNome(String nome){
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getUsuarioNome(nome);
    }
    public Usuario getUsuarioId(int idServidor){
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getUsuarioId(idServidor);
    }
    public List<Funcionario> getUsuarioCpf(String cpf){
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getUsuarioCpf(cpf);
    }
}
