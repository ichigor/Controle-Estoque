package modelo;


public class Produto {
    
    private String nomeProduto;
    private String localizacao;
    private float qtdMin;
    private float qtdAtual;
    private int idProduto;
    private Unidade unidade;

    public Produto() {
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public float getQtdMin() {
        return qtdMin;
    }

    public void setQtdMin(float qtdMin) {
        this.qtdMin = qtdMin;
    }

    public float getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(float qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    
    
    
    
}
