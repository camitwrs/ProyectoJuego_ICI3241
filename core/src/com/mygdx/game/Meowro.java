package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Meowro extends ApplicationAdapter {
	private OrthographicCamera camera; // Area que estare viendo.
	private SpriteBatch batch; // Area sobre la cual se colocan los "dibujos/sprites". Lienzo.
	private BitmapFont font; // Texto.
	private Texture fondo;
	   
	private Gato gato;
	   
	@Override
	
	public void create () { // Inicializar estructuras de datos y cargar todos los assets. 	
		font = new BitmapFont(); // use libGDX's default Arial font
		 
		// load the images for the droplet and the bucket, 64x64 pixels each 	     
		gato = new Gato(new Texture(Gdx.files.internal("sprite_gato/cat_idle.png")));
       
	    // load the drop sound effect and the rain background "music" 
		//Texture gota = new Texture(Gdx.files.internal("drop.png"));
		//Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
       
		//Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
      
	    //Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		//lluvia = new Lluvia(gota, gotaMala, dropSound, rainMusic);
	    
		fondo = new Texture("fondo.jpg"); // Carga la textura del fondo.
		
		// camara
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 500);
		batch = new SpriteBatch();
		
		// creacion del gato
		gato.crear();
		  
		// creacion de la lluvia
		//lluvia.crear();
	}



	@Override
	public void render () { // Va actualizando el "dibujo". 60 FPS.
		//limpia la pantalla. limpia cada vez que renderiza sino deja efecto de arrastre.
		//ScreenUtils.clear(1, 0, 0, 1);
		
		//actualizar matrices de la cámara
		camera.update();
		
		//actualizar 
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(fondo, 0, 0); // dibuja el fondo
		
		//dibujar textos
		//font.draw(batch, "Gotas totales: " + tarro.getPuntos(), 5, 795);
		//font.draw(batch, "Vidas : " + tarro.getVidas(), 720, 795);
		
		//if (!tarro.estaHerido()) {
			// movimiento del tarro desde teclado
	        // tarro.actualizarMovimiento();  
		gato.actualizarMov();
			// caida de la lluvia y choque
	        //lluvia.actualizarMovimiento(tarro);	   
		//}
		
		gato.dibujar(batch);
		//lluvia.actualizarDibujoLluvia(batch);
		
		batch.end();	
		
	}
	
	@Override
	public void dispose () { // Destruir lo inicializado al principio. Se llama 1 vez al final. Libera memoria.
		//tarro.destruir();
		gato.destruir();
		//lluvia.destruir();
	    batch.dispose();
	    font.dispose();
	}
}
