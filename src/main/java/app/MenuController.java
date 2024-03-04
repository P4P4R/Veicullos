package app;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;


public class MenuController {
    
    @FXML
    private void listarRetirada() throws IOException{
        App.setRoot("listarRetirada");
    }  
    @FXML
    private void cadastrarMotorista() throws IOException {
        App.setRoot("novoMotorista");
    }
    
    @FXML
    private void excluirMotorista() throws IOException{
        App.setRoot("excluirMotorista");
    }
    
    @FXML
    private void listarMotorista() throws IOException{
        App.setRoot("listarMotorista");
    }
    
    @FXML
    private void cadastrarOperador() throws IOException {
        App.setRoot("novoOperador");
    }
    
    @FXML
    private void getRetirada() throws IOException {
        App.setRoot("getRetirada");
    }

    
    @FXML
    private void retirarVeiculo() throws IOException{
        App.setRoot("retiradaVeiculo");
    }
    
    @FXML
    private void cadastrarVeiculo() throws IOException{
        App.setRoot("novoVeiculo");
    }
    
    @FXML
    private void listarVeiculo() throws IOException{
        App.setRoot("listarVeiculo");
    }
    @FXML
    private void retiradaDevolucao() throws IOException {
        App.setRoot("retiradaDevolucao");
    }    
    
    @FXML
    private void sair(){
        Platform.exit();
        System.exit(0);
    }
    
}
