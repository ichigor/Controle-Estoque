
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Unidade;

public class UnidadeTableModel extends AbstractTableModel{
    private List<Unidade> unidades;
    
    public UnidadeTableModel(){
        unidades = new ArrayList<Unidade>();        
    }
    
    public UnidadeTableModel(List<Unidade> lista){
        this();
        unidades.addAll(lista);
    }
    @Override
    public int getRowCount(){
        //quantidade de linhas
        return unidades.size();
    }

    @Override
    public int getColumnCount() {
        //quantidade de colunas
        return 1;
    }

    @Override
    public String getColumnName(int column){
        //qual o nome da coluna
        //0 - nome; 1-cpf; 2-siape; 3-sala; 4-email;
        switch(column){
            case 0: return "Descricao";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Unidade unidade = unidades.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return unidade.getDescricao();
        }
        return "";
    }
    
    public Unidade getUnidade(int pos){
        if (pos>= unidades.size()){
            return null;
        }
        return unidades.get(pos);
    }
}
