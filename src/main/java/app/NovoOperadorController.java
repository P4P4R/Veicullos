package app;

import java.io.IOException;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import modelo.Operador;
import util.Dao;

public class NovoOperadorController {
    @FXML
    private TextField nome;

    @FXML
    private TextField endereco;

    @FXML
    private TextField login;

    @FXML
    private TextField senha;


    @FXML
    private void cadastrarOperador(){
        Operador operator = new Operador();

        operator.setNome(nome.getText());
        operator.setEndereco(endereco.getText());
        operator.setLogin(login.getText());
        operator.setSenha(login.getText());

        Dao<Operador> dao = new Dao(Operador.class);
        dao.inserir(operator);

        cleanInputs();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Operador cadastrado");
        alert.show();
    }

    @FXML
    private void cleanInputs(){
        nome.setText("");
        endereco.setText("");
        login.setText("");
        senha.setText("");
    }

    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}

