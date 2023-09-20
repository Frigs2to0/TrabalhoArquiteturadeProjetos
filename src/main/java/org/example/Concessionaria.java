package org.example;

import java.util.List;

public class Concessionaria {

    private Armazenamento gerador;

    public Concessionaria(Armazenamento gerador) {
        this.gerador = gerador;
    }

    public void salvarCarro(Carro carro) {
        gerador.salvarCarro(carro);
    }

    public void salvarMoto(Moto moto){
        gerador.salvarMoto(moto);
    }

    public void listarCarro(){
        List<Carro> carros = gerador.listarCarro();

        System.out.println("CARROS LISTADOS");
        for(Carro carro : carros) {
            System.out.println(carro.toString());
        }
    }

    public void listarMoto(){
        List<Moto> motos = gerador.listarMoto();

        System.out.println("\nMOTOS LISTADAS");
        for(Moto moto : motos) {
            System.out.println(moto.toString());
        }
    }



}
