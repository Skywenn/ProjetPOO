package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SceneController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void newEmployer(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Employer.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Create a new Employer");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL); //permet de pas supprimer la scene de base !
		stage.show();
		
	}
	
	public void newVehicule(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Vehicule.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Create a new Vehicule");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL); //permet de pas supprimer la scene de base !	
		stage.show();
	
	}
	
	public void switchToSceneBike(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Bike.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToSceneMotorcycle(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Motorcycle.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToMainScene(ActionEvent event) {
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			stage.close();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
