import java.util.List;

public class Neuro extends Medico{
    @Override
    public void realizarDiagnostico(Paciente paciente) {
        System.out.println("DIAGNOSTICO COM MEDICO NEUROLOGISTA");
        System.out.printf("O paciente %s está com sintomas de %s, sendo necessario realizar exames.\n",
                paciente.getNome(), paciente.getSintomas());
        fazerExame(paciente.getNome());
        preescreverMedicamentos(paciente.getSintomas());
        encerrarAtendimento(paciente);
    }

    @Override
    protected void preescreverMedicamentos(List<String> sintomas) {
        System.out.println("Medicamentos e cuidados sugeridos:");
        if(sintomas.contains("Exaqueca")){
            System.out.println("- Aspirina");
            System.out.println("- Corticoide");
        }
        if(sintomas.contains("Epilepsia")){
            System.out.println("- Anticonvulsivos");
            System.out.println("- Dormir 8h por dia");
            System.out.println("- Retorno ao medico para acompanhamento");
        }
        if(sintomas.contains("Insonia")){
            System.out.println("- Diazepam");
            System.out.println("- Nao consumir cafeina/taurina");
        }
    }

    private void fazerExame(String paciente){
        System.out.println("Neurologista: Realizando exames no paciente " + paciente);
    }
}
