package service;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente cadastrarCliente(String nome, String telefone, String endereco, String email) {
        Cliente cliente = new Cliente(proximoId++, nome, telefone, endereco, email);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }
}
