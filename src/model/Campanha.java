package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Campanha {
    private int id;
    private Date data;
    private String midiaUsada;
    private List<Cliente> clientesAtingidos;
    private double taxaRetorno;

    public Campanha(int id, Date data, String midiaUsada) {
        this.id = id;
        this.data = data;
        this.midiaUsada = midiaUsada;
        this.clientesAtingidos = new ArrayList<>();
        this.taxaRetorno = 0.0;
    }

    public void adicionarCliente(Cliente cliente) {
        clientesAtingidos.add(cliente);
    }

    public void calcularTaxaRetorno(int totalClientesAlvo) {
        if (totalClientesAlvo > 0) {
            this.taxaRetorno = (double) clientesAtingidos.size() / totalClientesAlvo * 100;
        }
    }

    @Override
    public String toString() {
        return "Campanha nº: " + id +
                " | Data: " + data +
                " | Mídia: " + midiaUsada +
                " | Clientes atingidos: " + clientesAtingidos.size() +
                " | Taxa de retorno: " + String.format("%.2f", taxaRetorno) + "%";
    }
}
