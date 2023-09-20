package org.example;

import java.util.List;

public interface Armazenamento {

    public void salvarCarro(Carro carro);
    List<Carro> listarCarro();
    public void salvarMoto(Moto moto);
    List<Moto>listarMoto();

}
