package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Gato {
	
	private Rectangle rectangulo;
	private Texture tex;
	private int velx = 100;
	private int vely = 100;
	
	public Gato(Texture tt) {
		tex = tt;
	}
	
	public void crear() {
		rectangulo = new Rectangle();
		rectangulo.x = 400;
		rectangulo.y = 250;
		rectangulo.width = 64; // Ancho del png del gato.
		rectangulo.height = 64; // Alto del png del gato.
	}
	
	public void dibujar(final SpriteBatch batch) {
		batch.draw(tex, rectangulo.x, rectangulo.y);
	}
	
	public void actualizarMov() { 
		   if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			   tex = new Texture(Gdx.files.internal("sprite_gato/cat_left.png"));
			   rectangulo.x -= velx * Gdx.graphics.getDeltaTime();
		   }
		   if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			   tex = new Texture(Gdx.files.internal("sprite_gato/cat_right.png"));
			   rectangulo.x += velx * Gdx.graphics.getDeltaTime();
		   }
		   if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			   tex = new Texture(Gdx.files.internal("sprite_gato/cat_down.png"));
			   rectangulo.y -= vely * Gdx.graphics.getDeltaTime();
		   }
		   if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			   tex = new Texture(Gdx.files.internal("sprite_gato/cat_up.png"));
			   rectangulo.y += vely * Gdx.graphics.getDeltaTime();
		   }
		   // que no se salga de los bordes 
		   if(rectangulo.x < 0) 
			   rectangulo.x = 0;
		   if(rectangulo.x > 800 - 64) 
			   rectangulo.x = 800 - 64;
		   if(rectangulo.y < 0) 
			   rectangulo.y = 0;
		   if(rectangulo.y > 500 - 64) 
			   rectangulo.y = 500 - 64;
	   }
	
	public void destruir() {
		tex.dispose();
	}
}
