package dao;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaDAO {
    private static ArrayList<Pessoa> pessoasArmazenadas = new ArrayList<>();
    private static Long proximoId = 1L;

    public PessoaDAO() {
        // Construtor vazio
    }

    public void salvarPessoa(Pessoa pessoa) {
        pessoa.setId(proximoId++);
        pessoasArmazenadas.add(pessoa);
        System.out.println("Pessoa salva com sucesso!");
    }

    public Pessoa getPessoaById(Long id) {
        for (Pessoa p : pessoasArmazenadas) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void atualizarPessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoasArmazenadas.size(); i++) {
            if (pessoasArmazenadas.get(i).getId().equals(pessoa.getId())) {
                pessoasArmazenadas.set(i, pessoa);
                System.out.println("Pessoa atualizada com sucesso!");
                return;
            }
        }
    }

    public void deletarPessoa(Pessoa pessoa) {
        pessoasArmazenadas.remove(pessoa);
        System.out.println("Pessoa deletada com sucesso!");
    }

    /**
     * Retorna todos os registros de Pessoa como um ArrayList.
     * @return ArrayList de Pessoas
     */
    public ArrayList<Pessoa> getTodasPessoas() {
        return new ArrayList<>(pessoasArmazenadas);
    }

    public static void fechar() {
        // Método para fechar conexões com BD (quando implementado)
    }
}