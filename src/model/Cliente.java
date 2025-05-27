package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private int pontosFidelidade;
    private List<Avaliacao> avaliacoes;

    public Cliente(int id, String nome, String telefone, String endereco, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.pontosFidelidade = 0;
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarPontos(int pontos) {
        this.pontosFidelidade += pontos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " | Telefone: " + telefone + " | Email: "+ email + " | Pontos: " + pontosFidelidade;
    }
}
