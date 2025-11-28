package model;

public class Consulta extends Recurso {
    private String descricaoConsulta;
    private Double valor;

    public Consulta(String nome, Integer anoRegistro, String descricaoConsulta, Double valor) {
        super(nome, anoRegistro);
        this.descricaoConsulta = descricaoConsulta;
        this.valor = valor;
    }

    public String getDescricaoConsulta() {
        return this.descricaoConsulta;
    }

    public void setDescricaoConsulta(String descricaoConsulta) {
        this.descricaoConsulta = descricaoConsulta;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public void descricao() {
        System.out.println("Tipo de Consulta: " + this.getNome());
        System.out.println("Ano de Registro: " + this.getAnoFabricacao());
        System.out.println("Descrição: " + this.descricaoConsulta);
        System.out.println("Valor: R$ " + String.format("%.2f", this.valor));
    }
}
