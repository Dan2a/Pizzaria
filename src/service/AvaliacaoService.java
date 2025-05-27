package service;

import model.Avaliacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoService {
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void registrarAvaliacao(String tipo, int idAvaliado, String nomeAvaliado, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(tipo, idAvaliado, nomeAvaliado, nota, comentario);
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return avaliacoes;
    }

    public List<Avaliacao> listarAvaliacoesPorId(String tipo, int id) {
        return avaliacoes.stream()
                .filter(a -> a.getTipo().equalsIgnoreCase(tipo) && a.getIdAvaliado() == id)
                .collect(Collectors.toList());
    }
}
