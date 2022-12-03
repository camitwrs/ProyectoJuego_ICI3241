package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.InputManagerSingleton;

public class MainMenuScreen implements Screen {

	@Override
	public void render(float delta) {
		// Limpia la pantalla
		ScreenUtils.clear(0, 0, 0, 1);
		// Dibuja el menu
		BaseGameSingleton.getInstance().getBatch().begin();
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Bienvenido a MEOWRO", 340, 350);
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Pulsa 'ENTER' para empezar", 330, 310);
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Pulsa 'ESCAPE' para SALIR", 330, 290);
		BaseGameSingleton.getInstance().getBatch().end();
		
		// Chequeo de input
		// ESCAPE
		if (InputManagerSingleton.getInstance().getInputMainMenu() == 1) {
			dispose();
			System.exit(0);
		}
		// ENTER
		if (InputManagerSingleton.getInstance().getInputMainMenu() == 3) {
			BaseGameSingleton.getInstance().setScreen(new GameScreen());
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
