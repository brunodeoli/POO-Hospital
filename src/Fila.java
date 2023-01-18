import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Paciente> pacientesEmEspera;

    public Fila() {
        this.pacientesEmEspera = new ArrayList<>();
    }

    private Fila(List<Paciente> pacientesEmEspera) {
        this.pacientesEmEspera = pacientesEmEspera;
    }

    public void aumentarFila(Paciente paciente) {
        this.pacientesEmEspera.add(paciente);
        paciente.setFilaAtual(this);
    }

    public void diminuirFila(Paciente paciente) {
        this.pacientesEmEspera.remove(paciente);
    }

    public List<Paciente> getPacientesEmEspera() {
        return pacientesEmEspera;
    }

    private void setPacientesEmEspera(List<Paciente> pacientesEmEspera) {
        this.pacientesEmEspera = pacientesEmEspera;
    }

    @Override
    public String toString() {
        return "Pacientes em espera = " + pacientesEmEspera;
    }
}
