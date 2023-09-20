package org.example;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Statement;
import org.example.Carro;
import org.example.Moto;
import java.util.List;

public class BancoDeDadosArmazenamento implements Armazenamento {

    Connection connection;

    public BancoDeDadosArmazenamento() {
        conectar();
    }

    void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
            System.out.println("Conectado ao banco");


            criarTabelas();
        } catch (Exception exception) {
            System.out.println("Erro ao conectar ao banco");
            exception.printStackTrace();
        }
    }

    private void criarTabelas() {
        try{
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS carros (id INTEGER PRIMARY KEY AUTOINCREMENT, marca STRING, modelo STRING, ano INTEGER, preco DOUBLE PRECISION, numeroPortas INTEGER)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS motos (id INTEGER PRIMARY KEY AUTOINCREMENT, marca STRING, modelo STRING, ano INTEGER, preco DOUBLE PRECISION, cilindradas INTEGER)");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void salvarCarro(Carro carro) {

        try {
            var stt = connection.prepareStatement("INSERT INTO carros (marca, modelo, ano, preco, numeroPortas) VALUES (?, ?, ?, ?, ?)");
            stt.setString(1, carro.marca);
            stt.setString(2, carro.modelo);
            stt.setInt(3, carro.anoFabricacao);
            stt.setDouble(4, carro.preco);
            stt.setInt(5, carro.numeroPortas);

            stt.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public List<Carro> listarCarro() {
        try {
            var stt = connection.createStatement();
            var resultado = stt.executeQuery("SELECT * FROM carros");

            var carros = new ArrayList<Carro>();

            while (resultado.next()) {
                var carro = new Carro();
                carro.marca = resultado.getString("marca");
                carro.modelo = resultado.getString("modelo");
                carro.anoFabricacao = resultado.getInt("ano");
                carro.preco = resultado.getDouble("preco");
                carro.numeroPortas = resultado.getInt("numeroPortas");
                carros.add(carro);
            }
            return carros;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }


    @Override
    public void salvarMoto(Moto moto) {
        try {
            var stt = connection.prepareStatement("INSERT INTO motos (marca, modelo, ano, preco, cilindradas) VALUES (?, ?, ?, ?, ?)");
            stt.setString(1, moto.marca);
            stt.setString(2, moto.modelo);
            stt.setInt(3, moto.anoFabricacao);
            stt.setDouble(4, moto.preco);
            stt.setInt(5, moto.cilindradas);

            stt.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Moto> listarMoto() {

        try {
            var stt = connection.createStatement();
            var resultado = stt.executeQuery("SELECT * FROM motos");

            var motos = new ArrayList<Moto>();

            while (resultado.next()) {
                var moto = new Moto();
                moto.marca = resultado.getString("marca");
                moto.modelo = resultado.getString("modelo");
                moto.anoFabricacao = resultado.getInt("ano");
                moto.preco = resultado.getDouble("preco");
                moto.cilindradas= resultado.getInt("cilindradas");
                motos.add(moto);
            }
            return motos;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }
}

