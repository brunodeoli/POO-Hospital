import java.util.Objects;

public abstract class Funcionario extends Pessoa{
    private String id;
    private Double salarioBase;
    private StatusFuncionario status;


    public Funcionario() {
        super();
        this.status = StatusFuncionario.LIVRE;
    }

    public Funcionario(String nome, String cpf, Contato contato, String id, Double salarioBase) {
        super(nome, cpf, contato);
        this.salarioBase = salarioBase;
        this.id = id;
        this.status = StatusFuncionario.LIVRE;
    }

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected Double getSalarioBase() {
        return salarioBase;
    }

    protected void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Funcionario)) return false;
        Funcionario funcionario = (Funcionario) o;
        boolean isEqual = this.getNome().equals(funcionario.getNome()) && this.id.equals(funcionario.id);
        return isEqual;
    }
}
