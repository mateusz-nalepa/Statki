package pl.kielce.tu.kronos.logic;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.kielce.tu.kronos.gui.MainWindow;

/**
 * 
 * @author Nalepa Mateusz & Olesinski Patryk
 *
 */
public class ClientStart extends Application {

	public static MainWindow mainWindow;
	public Model model;

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * startuje aplikacje okienkowo jako JAVAFX, wymagane jest, aby klasa dziedziczyla po Application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			mainWindow = new MainWindow();
			mainWindow.setStageFromPrimaryStage(primaryStage);
			mainWindow.changeStage("Ships", "StartGame", 590, 460);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}