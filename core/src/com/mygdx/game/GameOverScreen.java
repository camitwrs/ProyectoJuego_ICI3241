package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.InputManagerSingleton;

public class GameOverScreen implements Screen{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0, 1);
		BaseGameSingleton.getInstance().getBatch().begin();
		BaseGameSingleton.getInstance().getFont().setColor(Color.WHITE);
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Fin del juego :(", 100, 150);
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Máxima puntuación: "+ BaseGameSingleton.getInstance().getScore(), 100, 130);
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Si quieres jugar otra partida pulsa la tecla 'espacio'", 100, 110);
		BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Pulsa 'ESCAPE' para SALIR", 100, 90);
		BaseGameSingleton.getInstance().getBatch().end();
		
		if (InputManagerSingleton.getInstance().getInputMainMenu() == 4) {
			//Meowro.getInstance().setScore(0);
			BaseGameSingleton.getInstance().setScreen(new GameScreen());
		}
		if (InputManagerSingleton.getInstance().getInputMainMenu() == 1) {
			dispose();
			System.exit(0);
		}
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
		BaseGameSingleton.getInstance().dispose();
	}

}
