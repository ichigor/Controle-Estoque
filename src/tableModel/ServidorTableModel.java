
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Servidor;

public class ServidorTableModel extends AbstractTableModel{
    private List<Servidor> servidores;
    
    public ServidorTableModel(){
        servidores = new ArrayList<Servidor>();        
    }
    
    public ServidorTableModel(List<Servidor> lista){
        this();
        servidores.addAll(lista);
    }
    @Override
    public int getRowCount(){
        //quantidade de linhas
        return servidores.size();
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
            case 2: return "Siape";
            case 3: return "Sala";
            case 4: return "E-mail";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Servidor servidor = servidores.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return servidor.getNomeCompleto();
        }else if (columnIndex==1){
            return servidor.getCpf();
        }else if (columnIndex==2){
            return servidor.getSiape();
        }else if (columnIndex==3){
            return servidor.getSala();
        }else if (columnIndex==4){
            return servidor.getEmail();
        }
        return "";
    }
    
    public Servidor getServidor(int pos){
        if (pos>= servidores.size()){
            return null;
        }
        return servidores.get(pos);
    }
}
