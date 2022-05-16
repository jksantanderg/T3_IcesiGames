package screens;

import java.util.ArrayList;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;
import model.Box;
import model.Bullet;

public class ScreenA extends BaseScreen {

	// Los objetos sobre el escenario
	private Avatar avatar;
	private ArrayList<Bullet> bullets;
	private ArrayList<Box> boxes;

	public ScreenA(Canvas canvas) {
		super(canvas);
		avatar = new Avatar(canvas);
		bullets = new ArrayList<Bullet>();
		boxes = new ArrayList<>();

		boxes.add(new Box(canvas, 250,10));

	}


	@Override
	public void paint() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

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
	}
	
	
	public void calculateDistance() {
		// Calcular distancia
		for (int i = 0; i < boxes.size(); i++) {
			for (int j = 0; j < bullets.size(); j++) {
				
				//Comparar 
				Box b = boxes.get(i);
				Bullet p = bullets.get(j);
				
				double D = Math.sqrt( 
						Math.pow(b.getX()-p.getX(), 2) + 
						Math.pow(b.getY()-p.getY(), 2) 
				);
				
				if(D <= 20) {
					boxes.remove(i);
					bullets.remove(j);
					return;
				}		
			}
		}
	}

	@Override
	public void onClick(MouseEvent e) {
		MainWindow.SCREEN = (MainWindow.SCREEN + 1) % 2;
	}

	@Override
	public void onKey(KeyEvent e) {
		if (e.getCode().equals(KeyCode.A)) {
			avatar.moveXBy(-2);
		} else if (e.getCode().equals(KeyCode.W)) {
			avatar.moveYBy(-2);
		} else if (e.getCode().equals(KeyCode.S)) {
			avatar.moveYBy(2);
		} else if (e.getCode().equals(KeyCode.D)) {
			avatar.moveXBy(2);
		} else if (e.getCode().equals(KeyCode.SPACE)) {
			bullets.add(new Bullet(canvas, avatar.getX(), avatar.getY()));
		}

	}

}
