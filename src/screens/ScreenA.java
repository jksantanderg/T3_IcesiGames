package screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;
import model.Box;
import model.Bullet;


/**
 * This class contains all the visual elements of the video game. As the user
 * plays the video game this class keeps updating.
 * 
 * @author Yessica Santander
 * @author Gabriel Restrepo
 * @author Camilo Gonzalez
 *
 */
public class ScreenA extends BaseScreen {
	
	//Objects on the scenery
	private static final int maxBulletsInScreen = 7;
	private Avatar avatar;
	private ArrayList<Bullet> bullets;
	private ArrayList<Box> boxes;
	private static final int enemiesQuant = 5; // The limit is 10 enemies 
	
	/**
	 * This is the constructor method of the ScreenA
	 * 
	 * @param canvas
	 */
	public ScreenA(Canvas canvas) {
		super(canvas);
		avatar = new Avatar(canvas);
		bullets = new ArrayList<Bullet>();
		boxes = new ArrayList<>();

		int y = 10;

		for (int i = 0; i < enemiesQuant; i++) {
			if (canvas.getWidth() / enemiesQuant <= 75 && enemiesQuant * canvas.getWidth() / i == canvas.getWidth()) {
				y += 85;
				boxes.add(new Box(canvas, 15 + (int) (canvas.getWidth() / enemiesQuant) * i, y));
				y = 10;
			} else {
				boxes.add(new Box(canvas, 20 + (int) (canvas.getWidth() / enemiesQuant) * i, y));
			}
		}

	}
	
	/**
	 * This method paints the screen and executes the methods <b>destroyEnemy</b>
	 * and <b>endGame</b>.
	 */
	@Override
	public void paint() { 
		Image image = null;
		File file = new File("src/image/spaceBG.jpg");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gc.setFill(Color.BLACK);
		//gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.drawImage(image, 0, 0);
		
		avatar.paint();

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint();

			if (bullets.get(i).getY() > canvas.getHeight()) {
				bullets.remove(i);
				i--;
			}
		}
		for (int i = 0; i < boxes.size(); i++) {
			boxes.get(i).paint();

		}

		calculateDistance();

		endGame();

	}

	/**
	 * This method calculates the distance between every projectile and every enemy.
	 * If any proyectil has got close enough (By a defined distance) the enemy will
	 * disapear from the screen.
	 */
	public void calculateDistance() {
		// Calcular distancia
		for (int i = 0; i < boxes.size(); i++) {
			for (int j = 0; j < bullets.size(); j++) {

				// Comparar
				Box b = boxes.get(i);
				Bullet p = bullets.get(j);

				double d = Math.sqrt(Math.pow(b.getX() - p.getX(), 2) + Math.pow(b.getY() - p.getY(), 2));

				if (d <= 60) {
					boxes.remove(i);
					avatar.setScore(avatar.getScore()+1);
					bullets.remove(j);
					wonGame();
					return;
				}
				
				if(bullets.get(j).getY()<0) {
					bullets.remove(j);
				}
			}
		}
	}

	/**
	 * This method verifies if the avatar has touched an enemy. In case this is
	 * true, the game ends and the user loses.
	 */
	public void endGame() {
		for (int i = 0; i < boxes.size(); i++) {

			Box b = boxes.get(i);

			double D = Math.sqrt(Math.pow(b.getX() - avatar.getX(), 2) + Math.pow(b.getY() - avatar.getY(), 2));

			if (D <= 50 || boxes.get(i).getY() > canvas.getHeight()) {
				System.out.println("Ur score: " + avatar.getScore()*MainWindow.FRAMES);
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
				MainWindow.loseGame = true;
				return;
			}
		}

	}

	/**
	 * This method verifies if the user has won the game. The user wins the game if
	 * there are no more enemies on the screen.
	 */
	public void wonGame() {
			
		if (boxes.size() == 0) {
			System.out.println("Your score: " + avatar.getScore()*MainWindow.FRAMES);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
			MainWindow.winGame = true;
			return;
		}
	}

	/**
	 * This method updates the position of the avatar according to the pressed key
	 * (Moves the avatar). It also deploys a projectile if the user presses the
	 * space bar. There are 5 keys which action is set on the program.
	 * 
	 * "RIGHT" key ---> the avatar moves to the right. "LEFT" key ---> the avatar
	 * moves to the left. "[space bar]" key ---> the avatar deploys a projectile
	 */
	@Override
	public void onKeyPressed(KeyEvent e) {
		
		if (e.getCode().equals(KeyCode.LEFT)) {
			avatar.moveXBy(-4);
		}
		
		if (e.getCode().equals(KeyCode.RIGHT)) {
			avatar.moveXBy(4);
		}
		if (e.getCode().equals(KeyCode.SPACE)) {
			
			if(bullets.size() <= maxBulletsInScreen) {
				bullets.add(new Bullet(canvas, avatar.getX() + 35, avatar.getY()));
			}
		}

	}
	
	/**
	 * This an implemented method of the BaseScreen
	 */
	@Override
	public void onKeyReleased(KeyEvent e) {
		
	}

}
