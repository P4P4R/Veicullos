package app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modelo.VeiculoUsado;
import util.Dao;

import java.io.IOException;
import java.util.List;

public class ListarRetirada {
    @FXML
    private ListView<String> retiradas;

    private Dao<VeiculoUsado> dao;

    @FXML
    private void initialize() {
        dao = new Dao<>(VeiculoUsado.class);
        List<VeiculoUsado> listaRetirada = dao.listarTodos();
        List<String> dataRetirada = FXCollections.observableArrayList();
        for (VeiculoUsado retirada : listaRetirada) {
            dataRetirada.add(retirada.getMotorista() + " " + retirada.getVeiculo() + " " + retirada.getRetirada() + " " + retirada.getDevolucao());
        }
        retiradas.getItems().addAll(dataRetirada);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
}
