package org.example;

public class Moto extends Veiculo {

    public int cilindradas;

    @Override
    public String toString(){
        return super.toString() + ", Cilindradas: " + cilindradas;
    }

}
