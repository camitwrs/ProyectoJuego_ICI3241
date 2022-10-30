package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.InputManager;

public class MainMenuScreen implements Screen {

	@Override
	public void render(float delta) {
		// Limpia la pantalla
		ScreenUtils.clear(0.2f, 0, 0, 1);
		// Dibuja el menu
		Meowro.getInstance().getBatch().begin();
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Bienvenido a MEOWRO", 100, 150);
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Pulsa para empezar", 100, 130);
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Pulsa 'ESCAPE' para SALIR", 100, 110);
		Meowro.getInstance().getBatch().end();
		
		// Chequeo de input
		// ESCAPE
		if (InputManager.getInstance().getInputMainMenu() == 1) {
			dispose();
			System.exit(0);
		}
		// PANTALLA TOCADA
		if (InputManager.getInstance().getInputMainMenu() == 2) {
			Meowro.getInstance().setScreen(new GameScreen());
			dispose();
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
