package app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modelo.Veiculo;
import util.Dao;

import java.io.IOException;
import java.util.List;

public class ListarVeiculo {
  @FXML
  private ListView<String> veiculos;

  private Dao<Veiculo> dao;

  @FXML
  private void initialize() {
    dao = new Dao(Veiculo.class);
    List<Veiculo> listaVeiculos = dao.listarTodos();
    List<String> veiculos = FXCollections.observableArrayList();
    for (Veiculo veiculo : listaVeiculos) {
      veiculos.add(veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getPlaca());
    }
    this.veiculos.getItems().addAll(veiculos);
  }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
