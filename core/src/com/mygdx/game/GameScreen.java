package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.ObjectManager;
import com.mygdx.game.managers.ResourceManager;

public class GameScreen implements Screen{

	ResourceManager resManager;
	ObjectManager obManager;
	
	public GameScreen() {


		resManager = new ResourceManager();
		resManager.loadAllResources();

		obManager = new ObjectManager(resManager);

	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// Limpia y pinta rojo oscuro.
		ScreenUtils.clear(0.2f, 0, 0, 1);
		//Meowro.getInstance().getCamera().update();
		//Meowro.getInstance().getBatch().setProjectionMatrix(Meowro.getInstance().getCamera().combined); // Representa la vista combinada y la matriz de proyeccion.
		obManager.render(delta);
		
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
		// TODO Auto-generated method stub
		
	}

}
