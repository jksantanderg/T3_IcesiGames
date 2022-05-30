package main;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.ScreenA;

/**
 * This is the main class of the program. This program will emulate the video
 * game "SpaceInvaders", the user will be able to interact with the visual
 * interface of this game.
 * 
 * @author Yessica Santander
 * @author Gabriel Restrepo
 * @author Camilo Gonzalez
 */
public class Main extends Application {
	static Scanner sc = new Scanner(System.in);
	public static ScreenA screenA;

	/**
	 * This is the main class of the program, it will ask the user for the number of
	 * enemies that the program will generate.
	 */
	public static void main(String[] args) {

		launch(args);
	}

	/**
	 * This method initializes the main window of the video game
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainWindow.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
}