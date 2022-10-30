package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;

public class InputManager {
	
	private static InputManager instance = null;
	//crearlo en clase juego, render
	//para obtener Vector2, tiene que retornar Vector normalizado
	//todo lo que se aprete viene acá
	public Vector2 getInputMove() {
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
	}
	
	public int getInputMainMenu() {
		// CASO 1: Si la tecla "escape" es apretada.
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			return 1;
		
		// CASO 2: Si la pantalla es tocada con un click.
		if(Gdx.input.isTouched())
			return 2;
		
		// CASO 0 - Default: Si no apreta ni clickea nada.
		return 0;
	}
	
	public static InputManager getInstance() {
		if (instance == null)
			instance = new 	InputManager();
		
		return instance;
	}
	
	//donde llamas move del personaje(render)
	//multiplico vector x vel x dt
	
}
