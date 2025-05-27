package service;

import model.Campanha;
import model.Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CampanhaService {
    private List<Campanha> campanhas = new ArrayList<>();
    private int proximoId = 1;

    public Campanha criarCampanha(Date data, String midiaUsada) {
        Campanha campanha = new Campanha(proximoId++, data, midiaUsada);
        campanhas.add(campanha);
        return campanha;
    }

    public void adicionarClienteNaCampanha(Campanha campanha, Cliente cliente) {
        campanha.adicionarCliente(cliente);
    }

    public void calcularTaxaDeRetorno(Campanha campanha, int totalClientesAlvo) {
        campanha.calcularTaxaRetorno(totalClientesAlvo);
    }

    public List<Campanha> listarCampanhas() {
        return campanhas;
    }
}
