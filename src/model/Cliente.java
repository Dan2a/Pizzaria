package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private int id;
    private String endereco;
    private String email;
    private int pontosFidelidade;

    public Cliente(int id, String nome, String telefone, String endereco, String email) {
        super(nome, telefone);
        this.id = id;
        this.endereco = endereco;
        this.email = email;
        this.pontosFidelidade = 0;
    }

    public void adicionarPontos(int pontos) {
        this.pontosFidelidade += pontos;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + getNome() + " | Telefone: " + getTelefone() + " | Email: "+ email + " | Pontos: " + pontosFidelidade;
    }
}
