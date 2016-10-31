
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Operacao;
import modelo.Produto;

public class OperacaoTableModel extends AbstractTableModel{
    private List<Operacao> operacoes;
    
    public OperacaoTableModel(){
        operacoes = new ArrayList<Operacao>();        
    }
    
    public OperacaoTableModel(List<Operacao> lista){
        this();
        operacoes.addAll(lista);
    }
    @Override
    public int getRowCount(){
        //quantidade de linhas
        return operacoes.size();
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
            case 0: return "ID Operação";
            case 1: return "ID Usuario";
            case 2: return "ID Funcionario";
            case 3: return "Tipo";
            case 4: return "Observação";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Operacao op = operacoes.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return op.getIdOperacao();
        }else if (columnIndex==1){
            return op.getIdUsuario();
        }else if (columnIndex==2){
            return op.getIdFuncionario();
        }else if (columnIndex==3){
            return op.getTipo();
        }else if (columnIndex==4){
            return op.getObservacao();
        }return "";
        
        
    }
    public Operacao getOperacao(int pos){
        if (pos>= operacoes.size()){
            return null;
        }
        return operacoes.get(pos);
    }
}
