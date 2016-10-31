
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Bolsista;

public class BolsistaTableModel extends AbstractTableModel{
    private List<Bolsista> bolsistas;
    
    public BolsistaTableModel(){
        bolsistas = new ArrayList<Bolsista>();        
    }
    
    public BolsistaTableModel(List<Bolsista> lista){
        this();
        bolsistas.addAll(lista);
    }
    @Override
    public int getRowCount(){
        //quantidade de linhas
        return bolsistas.size();
    }

    @Override
    public int getColumnCount() {
        //quantidade de colunas
        return 4;
    }

    @Override
    public String getColumnName(int column){
        //qual o nome da coluna
        //0 - nome; 1-cpf; 2-siape; 3-sala; 4-email;
        switch(column){
            case 0: return "Nome";
            case 1: return "Cpf";
            case 2: return "Matricula";
            case 3: return "Funcionario";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Bolsista bolsista = bolsistas.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return bolsista.getNomeCompleto();
        }else if (columnIndex==1){
            return bolsista.getCpf();
        }else if (columnIndex==2){
            return bolsista.getMatricula();
        }else if (columnIndex==3){
            return bolsista.getServidor().getNomeCompleto();
        }
        return "";
    }
    public Bolsista getBolsista(int pos){
        if (pos>= bolsistas.size()){
            return null;
        }
        return bolsistas.get(pos);
    }
}
