package dao;

import java.util.ArrayList;

import model.Recurso;
import model.Consulta;

public class RecursoDAO {
    private static ArrayList<Recurso> recursosArmazenados = new ArrayList<>();
    private static Integer proximoId = 1;

    public RecursoDAO() {
        // Construtor vazio
    }

    public void salvarRecurso(Recurso recurso) {
        recurso.setId(proximoId++);
        recursosArmazenados.add(recurso);
        System.out.println("Recurso salvo com sucesso!");
    }

    public Recurso getRecursoById(Integer id) {
        for (Recurso r : recursosArmazenados) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public void atualizarRecurso(Recurso recurso) {
        for (int i = 0; i < recursosArmazenados.size(); i++) {
            if (recursosArmazenados.get(i).getId().equals(recurso.getId())) {
                recursosArmazenados.set(i, recurso);
                System.out.println("Recurso atualizado com sucesso!");
                return;
            }
        }
    }

    public void deletarRecurso(Recurso recurso) {
        recursosArmazenados.remove(recurso);
        System.out.println("Recurso deletado com sucesso!");
    }

    /**
     * Retorna todos os recursos (consultas) como um ArrayList.
     * @return ArrayList de Recursos
     */
    public ArrayList<Recurso> getRecursos() {
        return new ArrayList<>(recursosArmazenados);
    }

    /**
     * Retorna apenas as consultas.
     * @return ArrayList de Consultas
     */
    public ArrayList<Consulta> getConsultas() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        for (Recurso r : recursosArmazenados) {
            if (r instanceof Consulta) {
                consultas.add((Consulta) r);
            }
        }
        return consultas;
    }

    public static void fechar() {
        // Método para fechar conexões com BD (quando implementado)
    }
}
