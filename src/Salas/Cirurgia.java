package Salas;

import Pessoas.Funcionario;

public class Cirurgia extends Sala {
    public Cirurgia() {
    }

    public Cirurgia(Funcionario responsavel, Fila fila) {
        super(responsavel, fila);
    }
}
