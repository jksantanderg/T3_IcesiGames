package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is the Bullet class. This class represents the bullet that the avatar
 * shoots.
 * 
 * @author Yessica Santander
 * @author Gabriel Restrepo
 * @author Camilo Gonzalez
 */
public class Bullet {

	private Canvas canvas; // Canvas where the bullet is painted
	private GraphicsContext gc; // Graphic context attribute

	private int x, y; // positions x and y of the bullet
	private int sizeX; // this is the width of the bullet
	private int sizeY; // this is the height of the bullet
	private int speed; // this is the speed of movement of the bullet

	/**
	 * This is the constructor method of the bullet
	 * 
	 * @param canvas, Canvas, canvas where the bullet will be painted
	 * @param x,      int, this is the coordinate of the x axis of the enemy on the
	 *                screen
	 * @param y,      int, this is the coordinate of the y axis of the enemy on the
	 *                screen
	 */
	public Bullet(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		this.sizeX = 8;
		this.sizeY = 18;
		this.speed = 6;
	}

	/**
	 * This method paints the bullet on the screen
	 */
	public void paint() {
		gc.setFill(Color.AQUAMARINE);
		gc.fillOval(x, y, sizeX, sizeY);
		y -= speed;
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

}
