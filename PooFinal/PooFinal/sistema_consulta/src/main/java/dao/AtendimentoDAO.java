package dao;

import java.util.ArrayList;

import model.Atendimento;

public class AtendimentoDAO {
    private static ArrayList<Atendimento> atendimentosArmazenados = new ArrayList<>();
    private static Integer proximoId = 1;

    public AtendimentoDAO() {
        // Construtor vazio
    }

    public void salvarAtendimento(Atendimento atendimento) {
        atendimento.setId(proximoId++);
        atendimentosArmazenados.add(atendimento);
        System.out.println("Atendimento salvo com sucesso!");
    }

    public Atendimento getAtendimentoById(Integer id) {
        for (Atendimento a : atendimentosArmazenados) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public void atualizarAtendimento(Atendimento atendimento) {
        for (int i = 0; i < atendimentosArmazenados.size(); i++) {
            if (atendimentosArmazenados.get(i).getId().equals(atendimento.getId())) {
                atendimentosArmazenados.set(i, atendimento);
                System.out.println("Atendimento atualizado com sucesso!");
                return;
            }
        }
    }

    public void deletarAtendimento(Atendimento atendimento) {
        atendimentosArmazenados.remove(atendimento);
        System.out.println("Atendimento deletado com sucesso!");
    }

    /**
     * Retorna todos os atendimentos como um ArrayList.
     * @return ArrayList de Atendimentos
     */
    public ArrayList<Atendimento> getAtendimentos() {
        return new ArrayList<>(atendimentosArmazenados);
    }

    public static void fechar() {
        // Método para fechar conexões com BD (quando implementado)
    }
}
