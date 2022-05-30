package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This is the classs of the enemy. This class contains all the information
 * related with the enemy of the video game: the position of the enemy, the
 * speed of the enemy and the image of the enemy.
 * 
 * @author Yessica Santander
 * @author Gabriel Restrepo
 * @author Camilo Gonzalez
 */
public class Box {

	private Canvas canvas;
	private GraphicsContext gc;

	private double x; // this is the coordinate of the x axis of the enemy on the screen
	private double y; // this is the coordinate of the y axis of the enemy on the screen
	private double speed; // this is the number of pixels that the enemy travels by every time it is moved
							// to some direction
	private Image image; // this is the image of the enemy

	/**
	 * This is the constructor method of the enemy.
	 * 
	 * @param canvas, Canvas, this is the canvas of the video game
	 * @param x,      this is the coordinate of the x axis of the enemy on the
	 *                screen
	 * @param y,      this is the coordinate of the y axis of the enemy on the
	 *                screen
	 */
	public Box(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		gc = canvas.getGraphicsContext2D();

		File file = new File("src/image/enemy.png");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.x = x;
		this.y = y;
		this.speed = 1;
	}

	/**
	 * This method paints the enemy on the screen
	 */
	public void paint() {
		gc.drawImage(image, x, y);
		y += speed;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

}
