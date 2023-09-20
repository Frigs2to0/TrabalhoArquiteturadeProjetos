package org.example;

public class Veiculo {
    public String marca;
    public String modelo;
    public int anoFabricacao;
    public double preco;

    public String toString() {
        return "Marca: " + marca +
                "Modelo: " + modelo +
                "Ano de fabricação: " + anoFabricacao +
                "Preço: " + preco;
    }
}
