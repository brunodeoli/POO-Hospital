import java.util.List;

public class ClinicoGeral extends Medico{
    @Override
    public void realizarDiagnostico(Paciente paciente) {
        System.out.println("DIAGNOSTICO COM MEDICO CLINICO GERAL");
        System.out.printf("O paciente %s está com sintomas de %s. Sendo necessario repouso.\n",
                paciente.getNome(), paciente.getSintomas());
        preescreverMedicamentos(paciente.getSintomas());
        encerrarAtendimento(paciente);
    }

    @Override
    protected void preescreverMedicamentos(List<String> sintomas) {
        System.out.println("Medicamentos e cuidados sugeridos:");
        if(sintomas.contains("Gripe")){
            System.out.println("- Benegrip");
        }
        if(sintomas.contains("Febre")){
            System.out.println("- Dipirona");
        }
        if(sintomas.contains("Vomito")){
            System.out.println("- Dramin");
        }
    }
}
