package model;

import java.time.LocalDate;

public class Avaliacao {
    private String tipo; // Cliente, Motoboy ou Pizzaria
    private int idAvaliado; // ID do cliente ou motoboy
    private String nomeAvaliado;
    private int nota;
    private String comentario;
    private LocalDate data;

    public Avaliacao(String tipo, int idAvaliado, String nomeAvaliado, int nota, String comentario) {
        this.tipo = tipo;
        this.idAvaliado = idAvaliado;
        this.nomeAvaliado = nomeAvaliado;
        this.nota = nota;
        this.comentario = comentario;
        this.data = LocalDate.now();
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdAvaliado() {
        return idAvaliado;
    }

    @Override
    public String toString() {
        return "[" + tipo + "] ID: " + idAvaliado + " | " + nomeAvaliado +
                " | Nota: " + nota + " | " + comentario + " | Data: " + data;
    }
}
