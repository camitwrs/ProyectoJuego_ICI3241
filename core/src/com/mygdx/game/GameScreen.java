package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.ObjectManager;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.util.Constants;

public class GameScreen implements Screen{

	Texture fondo;
	public GameScreen() {

		ResourceManager.getInstance().loadAllResources();
		fondo = new Texture("fondo.jpg");

	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// Limpia y pinta rojo oscuro.
		ScreenUtils.clear(0, 0, 0, 1);
		Meowro.getInstance().getBatch().begin();
		Meowro.getInstance().getBatch().setColor(Color.WHITE);
		Meowro.getInstance().getBatch().draw(fondo, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		Meowro.getInstance().getBatch().end();
		//Meowro.getInstance().getCamera().update();
		//Meowro.getInstance().getBatch().setProjectionMatrix(Meowro.getInstance().getCamera().combined); // Representa la vista combinada y la matriz de proyeccion.
		// Actualiza
		ObjectManager.getInstance().update(delta);
		// Dibuja
		ObjectManager.getInstance().render();

		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		ObjectManager.getInstance().dispose();
		
	}

}
