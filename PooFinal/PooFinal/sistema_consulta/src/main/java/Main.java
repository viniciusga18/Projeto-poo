
import java.util.ArrayList;
import java.util.Scanner;

import dao.PessoaDAO;
import dao.RecursoDAO;
import dao.AtendimentoDAO;
import model.Atendimento;
import model.Funcionario;
import model.Consulta;
import model.Recurso;
import model.Pessoa;
import model.Paciente;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PessoaDAO pessoaDAO = new PessoaDAO();
        RecursoDAO recursoDAO = new RecursoDAO();
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE CONSULTA MÉDICA =====");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Cadastrar Médico");
            System.out.println("3 - Listar Pessoas");
            System.out.println("4 - Cadastrar Tipo de Consulta");
            System.out.println("5 - Listar Tipos de Consulta");
            System.out.println("6 - Registrar Atendimento");
            System.out.println("7 - Listar Atendimentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeP = sc.nextLine();
                    System.out.print("Email: ");
                    String emailP = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    Paciente p1 = new Paciente(nomeP, emailP, cpf, telefone);
                    pessoaDAO.salvarPessoa(p1);
                    System.out.println("Paciente cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeM = sc.nextLine();
                    System.out.print("Email: ");
                    String emailM = sc.nextLine();
                    System.out.print("CRM: ");
                    String crm = sc.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = sc.nextLine();
                    Funcionario med = new Funcionario(nomeM, emailM, crm, especialidade);
                    pessoaDAO.salvarPessoa(med);
                    System.out.println("Médico cadastrado com sucesso!\n");
                    break;

                case 3:
                    System.out.println("\n=== Lista de Pessoas ===");
                    ArrayList<Pessoa> pessoas = pessoaDAO.getTodasPessoas();
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        for (Pessoa p : pessoas) {
                            p.exibirInfo();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Tipo de Consulta: ");
                    String tipoConsulta = sc.nextLine();
                    System.out.print("Ano de Registro: ");
                    int anoReg = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descrição: ");
                    String descConsulta = sc.nextLine();
                    System.out.print("Valor (R$): ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    Consulta consulta = new Consulta(tipoConsulta, anoReg, descConsulta, valor);
                    recursoDAO.salvarRecurso(consulta);
                    System.out.println("Tipo de Consulta cadastrado!\n");
                    break;

                case 5:
                    System.out.println("\n=== Lista de Tipos de Consulta ===");
                    ArrayList<Recurso> recursos = recursoDAO.getRecursos();
                    if (recursos.isEmpty()) {
                        System.out.println("Nenhuma consulta cadastrada.");
                    } else {
                        for (Recurso c : recursos) {
                            c.descricao();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 6:
                    ArrayList<Pessoa> pessoasAten = pessoaDAO.getTodasPessoas();
                    ArrayList<Recurso> consultasAten = recursoDAO.getRecursos();
                    
                    if (pessoasAten.isEmpty() || consultasAten.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um paciente, um médico e um tipo de consulta cadastrados.\n");
                        break;
                    }
                    
                    System.out.println("Escolha o paciente (índice):");
                    for (int i = 0; i < pessoasAten.size(); i++) { 
                        if (pessoasAten.get(i) instanceof Paciente) {
                            System.out.println(i + " - " + pessoasAten.get(i).getNome() + " (Paciente)");
                        }
                    }
                    int idxPaciente = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escolha o médico (índice):");
                    for (int i = 0; i < pessoasAten.size(); i++) { 
                        if (pessoasAten.get(i) instanceof Funcionario) {
                            System.out.println(i + " - " + pessoasAten.get(i).getNome() + " (Médico)");
                        }
                    }
                    int idxMedico = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escolha o tipo de consulta (índice):");
                    for (int i = 0; i < consultasAten.size(); i++) {
                        System.out.println(i + " - " + consultasAten.get(i).getNome());
                    }
                    int idxConsulta = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Data do Atendimento (dd/mm/aaaa hh:mm): ");
                    String dataAten = sc.nextLine();
                    System.out.print("Diagnóstico: ");
                    String diagnostico = sc.nextLine();
                    System.out.print("Observações: ");
                    String obsAten = sc.nextLine();

                    Atendimento atendimento = new Atendimento(
                        (Pessoa) pessoasAten.get(idxPaciente),
                        (Pessoa) pessoasAten.get(idxMedico),
                        (Recurso) consultasAten.get(idxConsulta),
                        dataAten, diagnostico, obsAten
                    );
                    atendimentoDAO.salvarAtendimento(atendimento);
                    System.out.println("Atendimento registrado com sucesso!\n");
                    break;

                case 7:
                    System.out.println("\n=== Lista de Atendimentos ===");
                    ArrayList<Atendimento> atendimentos = atendimentoDAO.getAtendimentos();
                    if (atendimentos.isEmpty()) {
                        System.out.println("Nenhum atendimento registrado.");
                    } else {
                        for (Atendimento a : atendimentos) {
                            a.exibirDetalhes();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    PessoaDAO.fechar();
                    RecursoDAO.fechar();
                    AtendimentoDAO.fechar();
                    break;

                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (opcao != 0);

        sc.close();
    }
}
