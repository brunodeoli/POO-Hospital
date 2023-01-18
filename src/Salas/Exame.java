package Salas;

import Pessoas.Funcionario;

public class Exame extends Sala {
    public Exame() {
    }

    public Exame(Funcionario responsavel, Fila fila) {
        super(responsavel, fila);
    }
}
