package pl.kielce.tu.kronos.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * klasa ktora zarzadza zmianami nad glownym oknem aplikacji
 * @author Nalepa Mateusz & Olesinski Patryk
 *
 */
public class MainWindow {

	public Button tempButton;

	public Parent root;
	public Scene scene;
	public Stage stage;

	public Parent getRoot() {
		return root;
	}

	/**
	 * wczytanie pliku fxml o podanej nazwie
	 * @param fileFXML nazwa pliku fxml do wczytania
	 * @throws IOException
	 */
	public void setRoot(String fileFXML) throws IOException {
		
		this.root = FXMLLoader.load(getClass().getResource("/fxml/" + fileFXML + ".fxml"));
	}

	public Scene getScene() {
		return scene;
	}

	/**
	 * klasa ustalacja rozmiar nowej sceny do wysietlania widoku oraz ustawienie arkusza stylow zeby odpowiedni formowatowac dane na widoku
	 * @param root - referenacja na obiekt krory zawiera uklad przyciskow na widoku
	 * @param width - szerokosc okna
	 * @param height - wysokosc okna
	 */
	public void setScene(Parent root, int width, int height) {
		this.scene = new Scene(root, width, height);
		this.scene.getStylesheets().add(getClass().getResource("/stylesheet/Stylesheet.css").toString());
	}

	public Stage getStage() {
		return stage;
	}

	public void setStageFromPrimaryStage(Stage primaryStage) {
		this.stage = primaryStage;
	}

	/**
	 * ustawienie informacji zwiazanych z oknem ktore jest do wydawania
	 * @param title - tytul okna
	 */
	public void setStage(String title) {
		this.stage.setTitle(title);
		this.stage.setScene(getScene());

		
		stage.setOnCloseRequest(e -> {
			e.consume();
			try {
				CloseWindow.display();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}); 

		this.stage.centerOnScreen();
		this.stage.show();
		this.stage.setResizable(false);

	}

	public void changeStage(String title, String fileFXML, int width, int height) throws IOException {
		setRoot(fileFXML);
		setScene(getRoot(), width, height);
		setStage(title);
	}

	public void setTemp(ActionEvent e) {
		this.tempButton = (Button) e.getSource();
	}

	public void setNewStage() {
		this.stage = (Stage) this.tempButton.getScene().getWindow();
	}

}
