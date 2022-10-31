package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.ObjectManager;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.util.Constants;

public class GameScreen implements Screen{

	ResourceManager resManager;
	ObjectManager obManager;
	Texture fondo;
	public GameScreen() {


		resManager = new ResourceManager();
		resManager.loadAllResources();

		obManager = new ObjectManager(resManager);
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
		//Meowro.getInstance().getBatch().draw(fondo,0,0);
		Meowro.getInstance().getBatch().draw(fondo, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		Meowro.getInstance().getBatch().end();
		//Meowro.getInstance().getCamera().update();
		//Meowro.getInstance().getBatch().setProjectionMatrix(Meowro.getInstance().getCamera().combined); // Representa la vista combinada y la matriz de proyeccion.
		// Actualiza
		obManager.update(delta);
		// Dibuja
		obManager.render();

		
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
		obManager.dispose();
		
	}

}
