package controller;

import model.*;
import service.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        MotoboyService motoboyService = new MotoboyService();
        AvaliacaoService avaliacaoService = new AvaliacaoService();
        PedidoService pedidoService = new PedidoService();
        CampanhaService campanhaService = new CampanhaService();
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== Sistema de CRM Pizzaria ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Motoboy");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Listar Motoboys");
            System.out.println("5 - Criar Pedido");
            System.out.println("6 - Listar Pedidos");
            System.out.println("7 - Registrar Avaliação");
            System.out.println("8 - Listar Avaliações");
            System.out.println("9 - Criar Campanha");
            System.out.println("10 - Listar Campanhas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== INSIRA OS DADOS DO CLIENTE ===");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    Cliente cliente = clienteService.cadastrarCliente(nome, telefone, endereco, email);
                    System.out.println("Cliente cadastrado: " + cliente);
                }
                case 2 -> {
                    System.out.println("=== INSIRA OS DADOS DO MOTOBOY ===");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Placa do veiculo: ");
                    String placaVeiculo = sc.nextLine();
                    Motoboy motoboy = motoboyService.cadastrarMotoboy(nome, telefone, placaVeiculo);
                    System.out.println("Motoboy cadastrado: " + motoboy);
                }
                case 3 -> {
                    System.out.println("=== CLIENTES CADASTRADOS ===");
                    clienteService.listarClientes().forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("=== MOTOBOYS CADASTRADOS ===");
                    motoboyService.listarMotoboys().forEach(System.out::println);
                }
                case 5 -> {
                    System.out.println("=== CRIAR PEDIDO ===");
                    List<Cliente> clientes = clienteService.listarClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }
                    System.out.println("Clientes cadastrados:");
                    clientes.forEach(System.out::println);

                    System.out.print("ID do Cliente: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine();
                    Cliente cliente = clienteService.buscarPorId(idCliente).orElse(null);

                    List<Motoboy> motoboys = motoboyService.listarMotoboys();
                    if (motoboys.isEmpty()) {
                        System.out.println("Nenhum motoboy cadastrado.");
                        break;
                    }
                    System.out.println("Motoboys cadastrados:");
                    motoboys.forEach(System.out::println);

                    System.out.print("ID do Motoboy: ");
                    int idMotoboy = sc.nextInt();
                    sc.nextLine();
                    Motoboy motoboy = motoboyService.buscarPorId(idMotoboy).orElse(null);

                    if (cliente == null || motoboy == null) {
                        System.out.println("Cliente ou Motoboy não encontrado.");
                        break;
                    }

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Valor do pedido: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    Pedido pedido = pedidoService.criarPedido(cliente, motoboy, descricao , valor);
                    System.out.println("Pedido criado: " + pedido);
                }
                case 6 -> {
                    System.out.println("=== PEDIDOS REALIZADOS ===");
                    List<Pedido> pedidos = pedidoService.listarPedidos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido registrado.");
                    } else {
                        pedidos.forEach(System.out::println);
                    }
                }
                case 7 -> {
                    int subOpcao;
                    do {
                        System.out.println("\n--- Avaliações ---");
                        System.out.println("1 - Avaliar Cliente");
                        System.out.println("2 - Avaliar Motoboy");
                        System.out.println("3 - Avaliar Pizzaria");
                        System.out.println("4 - Consultar Avaliações de Cliente");
                        System.out.println("5 - Consultar Avaliações de Motoboy");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        subOpcao = sc.nextInt();
                        sc.nextLine();

                        switch (subOpcao) {
                            case 1 -> {
                                System.out.println("Clientes cadastrados:");
                                clienteService.listarClientes().forEach(System.out::println);

                                System.out.print("ID Cliente: ");
                                int idCliente = sc.nextInt();
                                sc.nextLine();
                                Cliente cliente = clienteService.buscarPorId(idCliente).orElse(null);
                                if (cliente != null) {
                                    System.out.print("Nota para o Cliente (0-10): ");
                                    int nota = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Comentário: ");
                                    String comentario = sc.nextLine();
                                    avaliacaoService.registrarAvaliacao("Cliente", cliente.getId(), cliente.getNome(), nota, comentario);
                                    cliente.adicionarPontos(5);
                                    System.out.println("Avaliação registrada e pontos adicionados!");
                                } else {
                                    System.out.println("Cliente não encontrado.");
                                }
                            }
                            case 2 -> {
                                System.out.println("Motoboys cadastrados:");
                                motoboyService.listarMotoboys().forEach(System.out::println);

                                System.out.print("ID Motoboy: ");
                                int idMotoboy = sc.nextInt();
                                sc.nextLine();
                                Motoboy motoboy = motoboyService.buscarPorId(idMotoboy).orElse(null);
                                if (motoboy != null) {
                                    System.out.print("Nota para o Motoboy (0-10): ");
                                    int nota = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Comentário: ");
                                    String comentario = sc.nextLine();
                                    avaliacaoService.registrarAvaliacao("Motoboy", motoboy.getId(), motoboy.getNome(), nota, comentario);
                                    System.out.println("Avaliação registrada!");
                                } else {
                                    System.out.println("Motoboy não encontrado.");
                                }
                            }
                            case 3 -> {
                                System.out.print("Nota para a Pizzaria (0-10): ");
                                int nota = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Comentário: ");
                                String comentario = sc.nextLine();
                                avaliacaoService.registrarAvaliacao("Pizzaria", 0, "Pizzaria Delivery", nota, comentario);
                                System.out.println("Avaliação registrada!");
                            }
                            case 4 -> {
                                System.out.println("Clientes cadastrados:");
                                clienteService.listarClientes().forEach(System.out::println);

                                System.out.print("ID Cliente: ");
                                int idCliente = sc.nextInt();
                                sc.nextLine();
                                List<Avaliacao> avaliacoesCliente = avaliacaoService.listarAvaliacoesPorId("Cliente", idCliente);
                                System.out.println("--- Avaliações do Cliente ---");
                                avaliacoesCliente.forEach(System.out::println);
                            }
                            case 5 -> {
                                System.out.println("Motoboys cadastrados:");
                                motoboyService.listarMotoboys().forEach(System.out::println);

                                System.out.print("ID Motoboy: ");
                                int idMotoboy = sc.nextInt();
                                sc.nextLine();
                                List<Avaliacao> avaliacoesMotoboy = avaliacaoService.listarAvaliacoesPorId("Motoboy", idMotoboy);
                                System.out.println("--- Avaliações do Motoboy ---");
                                avaliacoesMotoboy.forEach(System.out::println);
                            }
                            case 0 -> System.out.println("Voltando ao menu principal...");
                            default -> System.out.println("Opção inválida.");
                        }
                    } while (subOpcao != 0);
                }
                case 8 -> {
                    System.out.println("=== LISTA DE AVALIAÇÕES ===");
                    avaliacaoService.listarAvaliacoes().forEach(System.out::println);
                }
                case 9 -> {
                    System.out.println("=== CRIAR CAMPANHA ===");
                    System.out.print("Mídia usada: ");
                    String midia = sc.nextLine();

                    System.out.print("Total de clientes alvo: ");
                    int totalAlvo = sc.nextInt();
                    sc.nextLine();

                    Date data = new Date();  // Pega a data atual

                    Campanha campanha = campanhaService.criarCampanha(data, midia);

                    System.out.println("Clientes cadastrados:");
                    clienteService.listarClientes().forEach(System.out::println);

                    System.out.println("Informe os IDs dos clientes atingidos, separados por vírgula:");
                    String ids = sc.nextLine();
                    String[] idsArray = ids.split(",");

                    for (String idStr : idsArray) {
                        int idCliente = Integer.parseInt(idStr.trim());
                        Cliente cliente = clienteService.buscarPorId(idCliente).orElse(null);
                        if (cliente != null) {
                            campanhaService.adicionarClienteNaCampanha(campanha, cliente);
                        }
                    }

                    campanhaService.calcularTaxaDeRetorno(campanha, totalAlvo);
                    System.out.println("Campanha criada: " + campanha);
                }

                case 10 -> {
                    System.out.println("=== CAMPANHAS CADASTRADAS ===");
                    campanhaService.listarCampanhas().forEach(System.out::println);
                }

                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
