package model;

public class Motoboy {
    private int id;
    private String nome;
    private String telefone;
    private String veiculo;

    public Motoboy(int id, String nome, String telefone, String veiculo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.veiculo = veiculo;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " | Telefone " + telefone + " | Veículo: " + veiculo;
    }
}
