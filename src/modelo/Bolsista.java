package modelo;
public class Bolsista extends Usuario{
    private int idBolsista;
    private String matricula;
    private Servidor servidor;    

    public Bolsista() {
    }

    public int getIdBolsista() {
        return idBolsista;
    }

    public void setIdBolsista(int idBolsista) {
        this.idBolsista = idBolsista;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    
    
}
