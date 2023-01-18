import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListaSintomas listaSintomas = new ListaSintomas();

        Paciente paciente1 = new Paciente("Bruno", "098", null, null, true  );
        Paciente paciente2 = new Paciente("Joao", "098", null, null, false  );
        Paciente paciente3 = new Paciente("Pedro", "098", null, null, true  );

        Fila filaAtendimento = new Fila();
        Fila filaCirurgia = new Fila();
        Fila filaConsulta = new Fila();
        Fila filaExame = new Fila();

        Atendente atendente = new Atendente();
        Medico cirurgiao = new Cirurgiao();
        Medico clinicoGeral = new ClinicoGeral();
        Medico neurologista = new Neuro();

        Sala salaAtendimento = new Atendimento(atendente, filaAtendimento);
        Sala salaCirurgia = new Cirurgia(cirurgiao, filaCirurgia);
        Sala salaConsulta = new Consulta(clinicoGeral, filaConsulta);
        Sala salaExame = new Exame(neurologista, filaExame);

        paciente1.entrarNoAtendimento(filaAtendimento);
        paciente2.entrarNoAtendimento(filaAtendimento);
        paciente3.entrarNoAtendimento(filaAtendimento);

        while(pacienteEmAtendimento(salaAtendimento, salaCirurgia, salaConsulta, salaExame)){
            if(salaCirurgia.verificarAtendimento()){
                Paciente primeiroDaFila = salaCirurgia.getFila().getPacientesEmEspera().get(0);
                cirurgiao.realizarDiagnostico(primeiroDaFila);
            }
            if(salaConsulta.verificarAtendimento()){
                Paciente primeiroDaFila = salaConsulta.getFila().getPacientesEmEspera().get(0);
                clinicoGeral.realizarDiagnostico(primeiroDaFila);
            }
            if(salaExame.verificarAtendimento()){
                Paciente primeiroDaFila = salaExame.getFila().getPacientesEmEspera().get(0);
                neurologista.realizarDiagnostico(primeiroDaFila);
            }
            if(salaAtendimento.verificarAtendimento()){
                Paciente primeiroDaFila = salaAtendimento.getFila().getPacientesEmEspera().get(0);
                atendente.iniciarAtendimento(primeiroDaFila, listaSintomas, scanner);
                int encaminhamento = atendente.verificarSintomas(primeiroDaFila.getSintomas());
                switch (encaminhamento) {
                    case 1 -> atendente.encaminhaSala(primeiroDaFila, filaCirurgia, "cirurgiao");
                    case 2 -> atendente.encaminhaSala(primeiroDaFila, filaConsulta, "clinico geral");
                    case 3 -> atendente.encaminhaSala(primeiroDaFila, filaExame, "neurologista");
                    default -> System.out.println("Sala nao encontrada");
                }
            }
        }
        scanner.close();
    }

    public static boolean pacienteEmAtendimento(Sala sala1, Sala sala2, Sala sala3, Sala sala4){
        System.out.println("Fila para medico atendimento - " + sala1.getFila());
        System.out.println("Fila para medico cirurgiao - " + sala2.getFila());
        System.out.println("Fila para medico clinico geral - " + sala3.getFila());
        System.out.println("Fila para medico neurologista - " + sala4.getFila());
        System.out.println("\n########################################\n");
        return sala1.verificarFilaDaSala() ||
                sala2.verificarFilaDaSala() ||
                sala3.verificarFilaDaSala() ||
                sala4.verificarFilaDaSala();
    }
}