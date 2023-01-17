public abstract class Funcionario extends Pessoa{
    private String id;
    private Double salarioBase;


    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String cpf, Contato contato, String id, Double salarioBase) {
        super(nome, cpf, contato);
        this.salarioBase = salarioBase;
        this.id = id;
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
}
