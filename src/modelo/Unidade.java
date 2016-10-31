
package modelo;


public class Unidade {
    
    private int id;
    private String descricao;

    public Unidade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Unidade{" + "descricao=" + descricao + '}';
    }
    
    
    
}
