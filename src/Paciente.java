import java.util.List;

public class Paciente extends Pessoa {
    private List<String> sintomas;
    private Boolean temConvenio;

    public Paciente() {
        super();
    }

    public Paciente(String nome, String cpf, Contato contato, List<String> sintomas, Boolean temConvenio) {
        super(nome, cpf, contato);
        this.sintomas = sintomas;
        this.temConvenio = temConvenio;
    }

    public void pagarConsulta(){
        if(this.temConvenio == true){
            System.out.println("Consulta por convenio");
        }else{
            System.out.println("Consulta paga");
        }

    }

    public void entrarNaFila(Fila fila){
        fila.aumentarFila();
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public Boolean getTemConvenio() {
        return temConvenio;
    }

    public void setTemConvenio(Boolean temConvenio) {
        this.temConvenio = temConvenio;
    }
}
