package model;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Motoboy motoboy;
    private String descricao;
    private double valor;
    private int pontosGerados;

    public Pedido(int id, Cliente cliente, Motoboy motoboy,String descricao, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.motoboy = motoboy;
        this.descricao = descricao;
        this.valor = valor;
        this.pontosGerados = (int) (valor / 10);
        this.cliente.adicionarPontos(pontosGerados);
    }

    @Override
    public String toString() {
        return "Pedido nº: " + id +
                " | Descricão: " + descricao +
                " | Valor: R$ " + String.format("%.2f", valor) +
                " | Cliente: " + cliente.getNome() +
                " | Motoboy: " + motoboy.getNome();
    }
}
