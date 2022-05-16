package main;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.ScreenA;

public class Main extends Application{
	static Scanner  sc = new Scanner (System.in);
	public static ScreenA screenA;
	public static void main(String[] args) {
		
		System.out.println("Enter the number of enemies");
		int n = sc.nextInt ();
		
		create(n);
		
		launch(args);
	}
	public static void create(int n) {
		
	}

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