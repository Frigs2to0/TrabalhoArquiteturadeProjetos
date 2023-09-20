package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoArmazenamento implements Armazenamento {

    private File arquivo = new File("dados.txt");
    private List<Carro> carros = new ArrayList<>();
    private List<Moto> motos = new ArrayList<>();

    public void Arquivo() {
        criarArquivo();
        lerArquivo();
    }

    private void criarArquivo() {
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo dados.txt criado!");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void lerArquivo() {
        try {
            Scanner scan = new Scanner(arquivo);
            String tipo = null;
            while (scan.hasNextLine()) {
                String linha = scan.nextLine();

                if (linha.equals("carros")) {
                    tipo = "carro";
                } else if (linha.equals("motos")) {
                    tipo = "moto";
                } else if (tipo != null) {
                    Veiculo veiculo;
                    String[] split = linha.split(",");
                    if (tipo.equals(carros)) {
                        Carro carro = new Carro();
                        veiculo = carro;
                        carros.add(carro);
                        carro.numeroPortas = Integer.parseInt(split[4]);
                    } else {
                        Moto moto = new Moto();
                        veiculo = moto;
                        motos.add(moto);
                        moto.cilindradas = Integer.parseInt(split[4]);
                    }
                    veiculo.marca = split[0];
                    veiculo.modelo = split[1];
                    veiculo.anoFabricacao = Integer.parseInt(split[2]);
                    veiculo.preco = Double.parseDouble(split[3]);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private  String textoVeiculo(Veiculo veiculo) {
        return veiculo.marca + "," + veiculo.anoFabricacao + "," + veiculo.modelo + "," + veiculo.preco;
    }

    private void salvarDados() {
        try {
            List<String> linhas = new ArrayList<>();

            linhas.add("carros");
            for (Carro carro : carros) {
                linhas.add(textoVeiculo(carro) + "," + carro.numeroPortas);
            }

            linhas.add("motos");
            for (Moto moto : motos) {
                linhas.add(textoVeiculo(moto) + "," + moto.cilindradas);
            }

            FileWriter fw = new FileWriter(arquivo);

            fw.write(String.join("\n", linhas));
            fw.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void salvarCarro(Carro carro) {
        carros.add(carro);
        salvarDados();
    }

    @Override
    public List<Carro> listarCarro() {
        return carros;
    }

    @Override
    public void salvarMoto(Moto moto) {
        motos.add(moto);
        salvarDados();
    }

    @Override
    public List<Moto> listarMoto() {
        return motos;
    }
}
