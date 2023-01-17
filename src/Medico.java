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

    protected abstract void realizarDiagnostico(List<String> sintomas);

    public String getCrm() {
        return crm;
    }
}