package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class InputManagerSingleton {
	
	private static InputManagerSingleton instance = null;
	
	public boolean isGoingLeft() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || (Gdx.input.isKeyPressed(Input.Keys.A))) {
			return true;
		}
		return false;
	}
	
	public boolean isGoingRight() {
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || (Gdx.input.isKeyPressed(Input.Keys.D))) {
			return true;
		}
		return false;
	}
	
	public boolean isGoingUp() {
		if (Gdx.input.isKeyPressed(Input.Keys.UP) || (Gdx.input.isKeyPressed(Input.Keys.W))) {
			return true;
		}
		return false;
	}
	
	public boolean isGoingDown() {
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || (Gdx.input.isKeyPressed(Input.Keys.S))) {
			return true;
		}
		return false;
	}
	
	public float getPosMouseX(float pointer) {
		return Gdx.input.getX();
	}
	
	public float getPosMouseY(float pointer) {
		return Gdx.input.getY();
	}
	
	public Vector2 mouseClicked(Rectangle rectangle) {
		if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
			Vector2 posMouse = new Vector2();
			posMouse.x = getPosMouseX(rectangle.x);
			posMouse.y = getPosMouseY(rectangle.y);
			System.out.println(posMouse.toString());
			//System.out.println(rectangle.x+","+rectangle.y);
			return posMouse;
		}
		return null;
	}
	
	public int getInputMainMenu() {
		// CASO 1: Si la tecla "escape" es apretada.
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			return 1;
		
		// CASO 2: Si la pantalla es tocada con un click.
		if(Gdx.input.isTouched())
			return 2;
		
		// CASO 3: Si la tecla "enter" es apretada.
		if(Gdx.input.isKeyPressed(Keys.ENTER))
			return 3;
		if(Gdx.input.isKeyPressed(Keys.SPACE))
			return 4;
		// CASO 0 - Default: Si no apreta ni clickea nada.
		return 0;
	}
	
	public static InputManagerSingleton getInstance() {
		if (instance == null)
			instance = new 	InputManagerSingleton();
		
		return instance;
	}

}
