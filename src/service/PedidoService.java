package service;

import model.Cliente;
import model.Motoboy;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private int proximoId = 1;

    public Pedido criarPedido(Cliente cliente, Motoboy motoboy,String descricao, double valor) {
        Pedido pedido = new Pedido(proximoId++, cliente, motoboy, descricao, valor);
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}

