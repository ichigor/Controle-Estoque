
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel{
    private List<Funcionario> funcionarios;
    
    public FuncionarioTableModel(){
        funcionarios = new ArrayList<Funcionario>();        
    }
    
    public FuncionarioTableModel(List<Funcionario> lista){
        this();
        funcionarios.addAll(lista);
    }
    @Override
    public int getRowCount(){
        //quantidade de linhas
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        //quantidade de colunas
        return 5;
    }

    @Override
    public String getColumnName(int column){
        //qual o nome da coluna
        //0 - nome; 1-cpf; 2-siape; 3-sala; 4-email;
        switch(column){
            case 0: return "Nome";
            case 1: return "Cpf";
            case 4: return "E-mail";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Funcionario funcionario = funcionarios.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return funcionario.getNomeCompleto();
        }else if (columnIndex==1){
            return funcionario.getCpf();
        }else if (columnIndex==4){
            return funcionario.getEmail();
        }
        return "";
    }
    
    public Funcionario getFuncionario(int pos){
        if (pos>= funcionarios.size()){
            return null;
        }
        return funcionarios.get(pos);
    }
}
