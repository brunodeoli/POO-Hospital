import java.util.List;

public class Cirurgiao extends Medico{
    @Override
    public void realizarDiagnostico(Paciente paciente) {
        System.out.println("DIAGNOSTICO COM MEDICO CIRURGIAO");
        System.out.printf("O paciente %s está com sintomas de %s, sendo necessario realizar cirurgia.\n",
                paciente.getNome(), paciente.getSintomas());
        fazerCirurgia(paciente.getNome());
        preescreverMedicamentos(paciente.getSintomas());
        encerrarAtendimento(paciente);
    }

    @Override
    protected void preescreverMedicamentos(List<String> sintomas) {
        System.out.println("Medicamentos e cuidados sugeridos:");
        System.out.println("- Analgesico");
        System.out.println("- Antibiotico");
        if(sintomas.contains("Fratura exposta") || sintomas.contains("Fratura")){
            System.out.println("- Imobilizacao");
            System.out.println("- Fisioterapia apos cicatrizacao");
        }
        if(sintomas.contains("Corte profundo")){
            System.out.println("- Curativo");
        }
    }

    private void fazerCirurgia(String paciente){
        System.out.println("Cirurgião: Realizando cirurgia no paciente " + paciente);
    }
}
