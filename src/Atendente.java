public class Atendente extends Funcionario{

    public Atendente() {
        super();
    }

    public Atendente(String nome, String cpf, Contato contato, String id, Double salarioBase) {
        super(nome, cpf, contato, id, salarioBase);
    }

    public void realizaAtendimento(Paciente paciente){
        System.out.println("Atendimento");
        this.cobrar(paciente);
    }

    private void cobrar(Paciente paciente){
        System.out.println("Cobrando do paciente");
        paciente.pagarConsulta();
    }
}
