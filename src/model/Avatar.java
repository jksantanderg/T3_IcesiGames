package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This is the class of the Avatar. This class contains all the information of
 * the avatar.
 * 
 * @author Yessica Santander
 * @author Gabriel Restrepo
 * @author Camilo Gonzalez
 *
 */
public class Avatar {

	private Canvas canvas; // Canvas where the bullet is painted
	private GraphicsContext gc; // Graphic context attribute

	private int x = 250; // this is the coordinate of the x axis of the enemy on the screen
	private int y = 300; // this is the coordinate of the y axis of the enemy on the screen
	private Image image; // this is the image of the avatar

	private int score; // this will be the accumulated score of the avatar

	/**
	 * This is the constructor method of the avatar class
	 * 
	 * @param canvas
	 */
	public Avatar(Canvas canvas) {
		this.canvas = canvas;
		gc = canvas.getGraphicsContext2D();

		File file = new File("src/image/Nave.png");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * This method paints the avatar on the screen
	 */
	public void paint() {
		gc.drawImage(image, x, y);
	}

	/**
	 * This method changes the X coordinate by adding "i"
	 * 
	 * @param i, int, this is the "i" units added
	 */
	public void moveXBy(int i) {
		this.x += i;
	}

	/**
	 * This method changes the Y coordinate by adding "i"
	 * 
	 * @param i, int, this is the "i" units added
	 */
	public void moveYBy(int i) {
		this.y += i;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
