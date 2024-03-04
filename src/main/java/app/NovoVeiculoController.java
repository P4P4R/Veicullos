package app;

import java.io.IOException;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import modelo.Veiculo;
import util.Dao;

public class NovoVeiculoController {
    @FXML
    private TextField marca;

    @FXML
    private TextField modelo;

    @FXML
    private TextField placa;

    @FXML
    private void cadastrarVeiculo(){
        Veiculo veiculo = new Veiculo();

        veiculo.setMarca(marca.getText());
        veiculo.setModelo(modelo.getText());
        veiculo.setPlaca(placa.getText());

        Dao<Veiculo> dao = new Dao(Veiculo.class);
        dao.inserir(veiculo);

        cleanInputs();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Veículo cadastrado");
        alert.show();
    }

    @FXML
    private void cleanInputs(){
        marca.setText("");
        modelo.setText("");
        placa.setText("");
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }

}

