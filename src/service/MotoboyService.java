package service;

import model.Motoboy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MotoboyService {
    private List<Motoboy> motoboys = new ArrayList<>();
    private int proximoId = 1;

    public Motoboy cadastrarMotoboy(String nome, String telefone, String placaVeiculo) {
        Motoboy motoboy = new Motoboy(proximoId++, nome, telefone, placaVeiculo);
        motoboys.add(motoboy);
        return motoboy;
    }

    public List<Motoboy> listarMotoboys() {
        return motoboys;
    }

    public Optional<Motoboy> buscarPorId(int id) {
        return motoboys.stream().filter(m -> m.getId() == id).findFirst();
    }
}
