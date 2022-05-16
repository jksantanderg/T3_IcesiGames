package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Box {
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x ;
	private int y ;
	private Image image;
	
	public Box(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		gc = canvas.getGraphicsContext2D();
		
		File file = new File("src/image/enemy.png");
		System.out.println(file.exists());
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.x = x;
		this.y = y;
	}

	public void paint() {
		gc.drawImage(image, x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
