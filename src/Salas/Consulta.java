package Salas;

import Pessoas.Funcionario;

public class Consulta extends Sala {
    public Consulta() {
    }

    public Consulta(Funcionario responsavel, Fila fila) {
        super(responsavel, fila);
    }
}
