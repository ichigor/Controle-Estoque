
package tableModel;

import controlador.ProdutoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Lista;
import modelo.Lista;
import modelo.Produto;

public class ListaTableModel extends AbstractTableModel{
    private List<Lista> produtos;
    
    public ListaTableModel(){
        produtos = new ArrayList<Lista>();        
    }
    
    public ListaTableModel(List<Lista> lista){
        this();
        produtos.addAll(lista);
    }
    @Override
    public int getRowCount(){
        //quantidade de linhas
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        //quantidade de colunas
        return 3;
    }

    @Override
    public String getColumnName(int column){
        //qual o nome da coluna
        //0 - nome; 1-cpf; 2-siape; 3-sala; 4-email;
        switch(column){
            case 0: return "id Produto";
            case 1: return "Nome";
            case 2: return "Quantidade";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Lista lista = produtos.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return lista.getIdProduto();
        }else if (columnIndex==1){
            
            String nome;
            ProdutoController pc = new ProdutoController();
            nome = pc.geProdutoNomeID(lista.getIdProduto());
            
            return nome;
        }else if (columnIndex==2){
            return lista.getQuantidade();
       
        }return "";
    }
    public Lista getLista(int pos){
        if (pos>= produtos.size()){
            return null;
        }
        return produtos.get(pos);
    }
}
