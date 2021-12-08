package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import application.Funcionario;
import connector.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	
	@FXML
	private TextField tx_nome;
	
	@FXML
	private TextField tx_sobrenome;
	
	@FXML
	private Button bt_salvar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	public void btSalvarOnClick(){
		
		Funcionario func = new Funcionario();
		
		func.setNome(tx_nome.getText());
		func.setSobrenome(tx_sobrenome.getText());
		
		try {
			Connection connect = DBConnector.getConnection();
			
			PreparedStatement pstm = connect.prepareStatement("insert into tbl_func(nome, sobrenome) values(?, ?)");
			
			pstm.setString(1, func.getNome());
			pstm.setString(2, func.getSobrenome());
			
			pstm.execute();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Funcionários");
			alert.setHeaderText("");
			alert.setContentText("Os dados do funcionário foram salvos");
			alert.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	};
	
	@FXML
	public void btCancelarOnClick(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Funcionários");
		alert.setHeaderText("");
		alert.setContentText("Ação cancelada");
		alert.show();
		
		tx_nome.clear();
		tx_sobrenome.clear();
		
	};
}
