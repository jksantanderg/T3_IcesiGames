package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import screens.BaseScreen;
import screens.ScreenA;

public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas;
	private GraphicsContext gc;
	
	public static int SCREEN = 0;
	public static long FRAMES = 0;
	
	private ArrayList<BaseScreen> screens;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		screens = new ArrayList<>();
		
		screens.add(new ScreenA(canvas));
	
	
		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);
		
		new Thread(() -> {
			while (true) {
				Platform.runLater(()->{
					paint();
				});
				pause(50);
				FRAMES++;
			}
		}).start();
	
		initEvents();
	}
	
	private void paint() {
		screens.get(SCREEN).paint();
	}

	public void initEvents() {
		//Lambda 1
		canvas.setOnMouseClicked(e -> {
			//screens.get(SCREEN).onClick(e);
		});
		//Lambda 2
		canvas.setOnKeyPressed(e -> {
			screens.get(SCREEN).onKey(e);	
		});
		
		canvas.setOnKeyReleased(e -> {
			//screens.get(SCREEN).onKey(e);	
		});
	}
	
	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
}
