package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;

public class InputManager {
	
	private static InputManager instance = null;
	
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
	
	/*public Vector2 getInputMove() {
		
		Vector2 input = new Vector2();
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			input.x = -1;
		} 
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			input.x = 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			input.y = -1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			input.y = 1;
		}
		
		return input;
	}*/
	
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
		
		// CASO 0 - Default: Si no apreta ni clickea nada.
		return 0;
	}
	
	public static InputManager getInstance() {
		if (instance == null)
			instance = new 	InputManager();
		
		return instance;
	}
	
	
}
