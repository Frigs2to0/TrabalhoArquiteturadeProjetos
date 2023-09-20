package org.example;

import org.example.Carro;
import org.example.Armazenamento;
import org.example.BancoDeDadosArmazenamento;
import org.example.Concessionaria;
import org.example.ArquivoArmazenamento;

public class Main {

    public static void main(String[] args) {

        Armazenamento gerador = new BancoDeDadosArmazenamento();
        ArquivoArmazenamento arquivo = new ArquivoArmazenamento();
        Concessionaria concessionaria = new Concessionaria(gerador);
        Concessionaria concessionaria2 = new Concessionaria(arquivo);

        Carro carro = Main.criarCarro();
        concessionaria.salvarCarro(carro);

        Moto moto = Main.criarMoto();
        concessionaria.salvarMoto(moto);

        concessionaria.listarCarro();
        concessionaria.listarMoto();

        carro = Main.criarCarro();
        concessionaria2.salvarCarro(carro);
        moto = Main.criarMoto();
        concessionaria2.salvarMoto(moto);

        concessionaria2.listarCarro();
        concessionaria2.listarMoto();

    }

    public static Carro criarCarro(){
        var carro = new Carro();

        carro.modelo = "Modelo do carro : 2";
        carro.marca = "Marca do carro: Toyota";
        carro.anoFabricacao = 2010;
        carro.numeroPortas = 4;
        carro.preco = 200.000;

        return carro;
    }


    public static Moto criarMoto(){
        var moto = new Moto();

        moto.modelo = " Modelo da moto : 44444 ";
        moto.marca = " Marca da moto: Honda ";
        moto.anoFabricacao = 2026 ;
        moto.cilindradas = 1000;
        moto.preco = 120000;

        return moto;
    }
}

