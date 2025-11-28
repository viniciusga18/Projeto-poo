package model;

public class Paciente extends Pessoa {
    private String cpf;
    private String telefone;

    protected Paciente() {}

    public Paciente(String nome, String email, String cpf, String telefone) {
        super(nome, email);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("e-mail: " + this.getEmail());
        System.out.println("CPF: " + this.cpf);
        System.out.println("Telefone: " + this.telefone);
    }

}
