import java.util.List;

public abstract class Medico extends Funcionario {
    private String crm;

    public Medico() {
        super();
    }

    public Medico(String nome, String cpf, Contato contato, String id, Double salarioBase, String crm) {
        super(nome, cpf, contato, id, salarioBase);
        this.crm = crm;
    }

    public abstract void realizarDiagnostico(Paciente paciente);

    protected abstract void preescreverMedicamentos(List<String> sintomas);

    public void encerrarAtendimento(Paciente paciente){
        System.out.println("Medico: Finalizando atendimento com paciente " + paciente.getNome());
        System.out.println("\n########################################\n");
        paciente.liberarSala(paciente.getFilaAtual());
        this.setStatus(StatusFuncionario.LIVRE);
    }

    public String getCrm() {
        return crm;
    }
}