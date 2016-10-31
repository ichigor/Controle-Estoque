
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Produto;

public class ProdutoTableModel extends AbstractTableModel{
    private List<Produto> produtos;
    
    public ProdutoTableModel(){
        produtos = new ArrayList<Produto>();        
    }
    
    public ProdutoTableModel(List<Produto> lista){
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
        return 5;
    }

    @Override
    public String getColumnName(int column){
        //qual o nome da coluna
        //0 - nome; 1-cpf; 2-siape; 3-sala; 4-email;
        switch(column){
            case 0: return "Produto";
            case 1: return "Localizacao";
            case 2: return "Unidade";
            case 3: return "Qtd.Min";
            case 4: return "Qtd.Atual";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o aluno da linha
        Produto produto = produtos.get(rowIndex);
        //verifica qual valor deve ser retornado
        if(columnIndex==0){
            return produto.getNomeProduto();
        }else if (columnIndex==1){
            return produto.getLocalizacao();
        }else if (columnIndex==2){
            return produto.getUnidade().getDescricao();
        }else if (columnIndex==3){
            return produto.getQtdMin();
        }else if (columnIndex==4){
            return produto.getQtdAtual();        
        }return "";
    }
    public Produto getProduto(int pos){
        if (pos>= produtos.size()){
            return null;
        }
        return produtos.get(pos);
    }
}
