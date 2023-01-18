package Pessoas;

import Salas.Fila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Atendente extends Funcionario {

    public Atendente() {
        super();
    }

    public Atendente(String nome, String cpf, Contato contato, String id, Double salarioBase) {
        super(nome, cpf, contato, id, salarioBase);
    }

    public void iniciarAtendimento(Paciente paciente, ListaSintomas lista, Scanner scanner){
        System.out.println("Atendente: Iniciando atendimento do paciente " + paciente.getNome());
        System.out.println("----------------------------------------");
        this.preencherSintomas(paciente,lista, scanner);
        System.out.println("----------------------------------------");
        this.cobrar(paciente);
        System.out.println("----------------------------------------");
    }

    public void preencherSintomas(Paciente paciente, ListaSintomas lista, Scanner scanner){
        System.out.println("PREENCHIMENTO DE SINTOMAS");
        System.out.println("Digite 'sim' para sintomas que esta sentindo.");
        System.out.println("Digite 'nao' para sintomas que não esta sentindo.");
        System.out.println("----------------------------------------");
        String sintoma;
        String resposta;

        for (int i = 0; i < lista.getSintomas().size(); i++) {
            sintoma = lista.getSintomas().get(i);
            System.out.println("Atendente: Você esta sentindo " + sintoma + "?");
            resposta = scanner.nextLine();
            RespostaCerta: while(true){
                if(resposta.equals("sim")){
                    paciente.addSintoma(sintoma);
                    break RespostaCerta;
                } else if (resposta.equals("nao")) {
                    break RespostaCerta;
                }else{
                    System.out.println("Resposta errada, digite somente 'sim' ou 'nao'");
                    resposta = scanner.nextLine();
                }
            }
        }
    }

    private void cobrar(Paciente paciente){
        System.out.println("Atendente: Cobrando do paciente " + paciente.getNome());
        paciente.pagarConsulta();
    }

    public int verificarSintomas(List<String> sintomas) {
        int encaminhaCirurgiao = 0;
        int encaminhaNeuro = 0;
        int encaminhaClinicoGeral = 0;

        for (int i = 0; i < sintomas.size(); i++) {
            if (sintomas.get(i).equals("Gripe") ||
                    sintomas.get(i).equals("Febre") ||
                    sintomas.get(i).equals("Vomito")) {
                encaminhaClinicoGeral++;
            }
            if (sintomas.get(i).equals("Fratura") ||
                    sintomas.get(i).equals("Fratura exposta") ||
                    sintomas.get(i).equals("Corte profundo")) {
                encaminhaCirurgiao++;
            }
            if (sintomas.get(i).equals("Exaqueca") ||
                    sintomas.get(i).equals("Epilepsia") ||
                    sintomas.get(i).equals("Insonia")) {
                encaminhaNeuro++;
            }
        }
        if (encaminhaCirurgiao >= encaminhaNeuro && encaminhaCirurgiao >= encaminhaClinicoGeral) {
            return 1;
        }
        if (encaminhaClinicoGeral >= encaminhaNeuro && encaminhaClinicoGeral >= encaminhaCirurgiao) {
            return 2;
        }
        if (encaminhaNeuro >= encaminhaCirurgiao && encaminhaNeuro >= encaminhaClinicoGeral) {
            return 3;
        }
        return 0;
    }

    public void encaminhaSala(Paciente paciente, Fila encaminhamento, String medico){
        System.out.println("Atendente: Encaminhando paciente " + paciente.getNome() + " para o medico " + medico);
        System.out.println("\n########################################\n");
        paciente.getFilaAtual().diminuirFila(paciente);
        encaminhamento.aumentarFila(paciente);
        this.setStatus(StatusFuncionario.LIVRE);
    }
}
