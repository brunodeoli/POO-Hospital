package Salas;

import Pessoas.Funcionario;
import Pessoas.StatusFuncionario;
import Salas.Fila;

public abstract class Sala {
    private Funcionario responsavel;
    private Fila fila;

    protected Sala() {
    }
    protected Sala(Funcionario responsavel, Fila fila) {
        this.responsavel = responsavel;
        this.fila = fila;
    }

    public void reservar(int dia, int mes, int ano){
    }

    public Boolean verificarFilaDaSala(){
        if(this.fila == null || this.fila.getPacientesEmEspera().isEmpty()){
            return false;
        }
        return true;
    }

    public Boolean verificarAtendimento(){
        if(verificarFilaDaSala() && this.getResponsavel().getStatus() == StatusFuncionario.LIVRE){
            this.getResponsavel().setStatus(StatusFuncionario.ATENDENDO);
            return true;
        }
        return false;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
}
