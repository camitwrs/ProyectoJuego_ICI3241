package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Meowro extends Game {
	private SpriteBatch batch; // Area sobre la cual se colocan los "dibujos/sprites". Lienzo.
	private BitmapFont font; // Texto.
	private OrthographicCamera camera; //misma camara siempre
	private ShapeRenderer sr;
	private int score;

	private static Meowro instance = null;
	
	@Override
	public void create () { // Inicializar estructuras de datos y cargar todos los assets. 	
			
		batch = new SpriteBatch();
		font = new BitmapFont();
		sr = new ShapeRenderer();
		setScreen(new MainMenuScreen());
	}

	@Override
	public void render () { // Va actualizando el "dibujo". 60 FPS.
		super.render();
		
	}
	
	@Override
	public void dispose () { // Destruir lo inicializado al principio. Se llama 1 vez al final. Libera memoria.
	    batch.dispose();
	    font.dispose();
	}
	
	public static Meowro getInstance() {
		if (instance == null)
			instance = new Meowro();
		
		return instance;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public ShapeRenderer getSR() {
		return sr;
	}
	
}
