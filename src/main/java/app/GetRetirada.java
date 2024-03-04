package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import modelo.Motorista;
import modelo.Veiculo;
import modelo.VeiculoUsado;
import util.Dao;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class GetRetirada {
  @FXML
  private ListView<String> motoristas;

  @FXML
  private ComboBox<Veiculo> veiculos;

  @FXML
  private DatePicker datePicker;

  private Dao<Veiculo> daoVeiculo;

  private Dao<VeiculoUsado> daoVeiculoUsado;

  @FXML
  private void initialize() {
    daoVeiculo = new Dao(Veiculo.class);
    daoVeiculoUsado = new Dao(VeiculoUsado.class);

    List<Veiculo> getVehicles = daoVeiculo.listarTodos();
    ObservableList<Veiculo> getVehiclesObservable = FXCollections.observableArrayList(getVehicles);
    veiculos.setItems(getVehiclesObservable);
  }

  @FXML
  private void getRetirada() {
    Veiculo vehicle = veiculos.getSelectionModel().getSelectedItem();
    LocalDate date = datePicker.getValue();

    List<String> drivers = FXCollections.observableArrayList();

    try {
      List<VeiculoUsado> vehiclesUseList = daoVeiculoUsado.listarTodos();

      for (VeiculoUsado veiculoUsado : vehiclesUseList) {
        if (String.valueOf(vehicle).equals(String.valueOf(veiculoUsado.getVeiculo()))) {
          if (String.valueOf(veiculoUsado.getRetirada()).equals(String.valueOf(date))) {
            drivers.add(veiculoUsado.getMotorista().getNome() + " " + veiculoUsado.getMotorista().getCnh());
          }

         else if (String.valueOf(veiculoUsado.getDevolucao()).equals(String.valueOf(date))) {
            drivers.add(veiculoUsado.getMotorista().getNome() + " " + veiculoUsado.getMotorista().getCnh());
          }

          else if (date.isAfter(veiculoUsado.getRetirada()) && date.isBefore(veiculoUsado.getDevolucao())) {
            drivers.add(veiculoUsado.getMotorista().getNome() + " " + veiculoUsado.getMotorista().getCnh());
          }
        }
      }

      this.motoristas.getItems().addAll(drivers);

      if (drivers.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Nenhum motorista retirou o veículo na data selecionada");
        alert.show();
      }
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText("Ocorreu um erro na busca pelo veículo");
      alert.show();
    }
  }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }

}
