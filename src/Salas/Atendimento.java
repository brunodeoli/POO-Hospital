package Salas;

import Pessoas.Funcionario;

public class Atendimento extends Sala {
    public Atendimento() {
    }

    public Atendimento(Funcionario responsavel, Fila fila) {
        super(responsavel, fila);
    }

}
