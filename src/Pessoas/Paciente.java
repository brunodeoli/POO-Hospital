package Pessoas;

import Salas.Fila;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    private List<String> sintomas;
    private Boolean temConvenio;
    private Fila filaAtual;

    public Paciente() {
        super();
    }

    public Paciente(String nome, String cpf, Contato contato, List<String> sintomas, Boolean temConvenio) {
        super(nome, cpf, contato);
        this.sintomas = sintomas;
        this.temConvenio = temConvenio;
        this.filaAtual = null;
    }

    public void pagarConsulta(){
        if(this.temConvenio){
            System.out.println("Paciente " + this.getNome() + ": Consulta por convenio");
        }else{
            System.out.println("Paciente " + this.getNome() + ": Consulta paga");
        }
    }

    public final void entrarNoAtendimento(Fila fila){
        this.filaAtual = fila;
        fila.aumentarFila(this);
    }

    public final void liberarSala(Fila fila){
        this.filaAtual = null;
        fila.diminuirFila(this);
    }

    protected final void addSintoma(String sintoma){
        if(this.sintomas == null){
            this.sintomas = new ArrayList<>();
        }
        this.sintomas.add(sintoma);
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

    public Fila getFilaAtual() {
        return filaAtual;
    }

    public void setFilaAtual(Fila filaAtual) {
        this.filaAtual = filaAtual;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        boolean isEqual = this.getNome().equals(paciente.getNome()) && this.getCpf().equals(paciente.getCpf());
        return isEqual;
    }
}
