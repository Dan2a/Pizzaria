package model;

public class Motoboy extends Pessoa {
    private int id;
    private String placaVeiculo;

    public Motoboy(int id, String nome, String telefone, String placaVeiculo) {
        super(nome, telefone);
        this.id = id;
        this.placaVeiculo = placaVeiculo;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + getNome() + " | Telefone " + getTelefone() + " | Placa do Veículo: " + placaVeiculo;
    }
}
