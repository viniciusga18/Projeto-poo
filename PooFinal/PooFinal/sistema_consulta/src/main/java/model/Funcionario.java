package model;

public class Funcionario extends Pessoa{
    private String crm;
    private String especialidade;

    protected Funcionario(){}

    public Funcionario(String nome, String email, String crm, String especialidade){
        super(nome, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return this.crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("e-mail: " + this.getEmail());
        System.out.println("CRM: " + this.crm);
        System.out.println("Especialidade: " + this.especialidade);
    }
}
