package control;

import java.awt.event.WindowEvent;
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

/**
 * This is the main window class. This class executes the Screen of the video
 * game.
 * 
 * @author Yessica Santander
 * @author Gabriel Restrepo
 * @author Camilo Gonzalez
 *
 */
public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas; // This is the canvas where the screen is painted
	private GraphicsContext gc; // Graphic context attribute

	public static long FRAMES = 0;

	public static boolean winGame = false; // This variable represents whether the user has won the game or not
	public static boolean loseGame = false; // This variable represents whether the user has lost the game or not

	private ArrayList<BaseScreen> screens; // This is the list of the video game screens.

	/**
	 * This method initializes the current screen
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		screens = new ArrayList<>();

		screens.add(new ScreenA(canvas));

		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);

		new Thread(() -> {
			while (true) {
				Platform.runLater(() -> {
					paint();

				});
				pause(30);
				FRAMES++;
				if (winGame) {
					System.out.println("You Win!");
					finishGame();
				} else if (loseGame) {
					System.out.println("You Lose!");
					finishGame();
				}
			}
		}).start();

		initEvents();

	}

	/**
	 * This method paints the current screen
	 */
	private void paint() {
		screens.get(0).paint();
	}

	/**
	 * This method closes the window
	 */
	public void finishGame() {
		Platform.exit();
		System.exit(0);
	}

	/**
	 * This method initializes certain operations on the current screen according to
	 * the pressed key
	 */
	public void initEvents() {

		canvas.setOnKeyPressed(e -> {
			screens.get(0).onKeyPressed(e);
		});

		canvas.setOnKeyReleased(e -> {
			screens.get(0).onKeyReleased(e);
		});
	}

	/**
	 * This method pauses the screen refresh rate
	 * 
	 * @param time, int, this is the time the screen is paused
	 */
	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
