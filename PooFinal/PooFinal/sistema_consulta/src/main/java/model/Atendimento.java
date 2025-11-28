package model;

public class Atendimento {
    private Integer id;
    private Pessoa paciente;
    private Pessoa medico;
    private Recurso consulta;
    private String dataAtendimento;
    private String diagnostico;
    private String observacoes;

    protected Atendimento() {}

    public Atendimento(Pessoa paciente, Pessoa medico, Recurso consulta, String dataAtendimento, String diagnostico, String observacoes) {
        this.paciente = paciente;
        this.medico = medico;
        this.consulta = consulta;
        this.dataAtendimento = dataAtendimento;
        this.diagnostico = diagnostico;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public Pessoa getMedico() {
        return this.medico;
    }

    public void setMedico(Pessoa medico) {
        this.medico = medico;
    }

    public Recurso getConsulta() {
        return this.consulta;
    }

    public void setConsulta(Recurso consulta) {
        this.consulta = consulta;
    }

    public String getDataAtendimento() {
        return this.dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void exibirDetalhes(){
        System.out.println("Data do Atendimento: " + this.dataAtendimento);
        System.out.println("Diagnóstico: " + this.diagnostico);
        System.out.println("Observações: " + this.observacoes);
        System.out.println("\n--- Paciente ---");
        this.paciente.exibirInfo();
        System.out.println("\n--- Médico ---");
        this.medico.exibirInfo();
        System.out.println("\n--- Tipo de Consulta ---");
        this.consulta.descricao();
    }
}
