package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.managers.ObjectManager;
import com.mygdx.game.managers.ResourceManager;

public class GameOverScreen implements Screen{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0, 1);
		Meowro.getInstance().getBatch().begin();
		Meowro.getInstance().getFont().setColor(Color.WHITE);
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Fin del juego :(", 100, 150);
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Máxima puntuación: "+ Meowro.getInstance().getScore(), 100, 130);
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Si quieres jugar otra partida pulsa la tecla 'espacio'", 100, 110);
		Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Pulsa 'ESCAPE' para SALIR", 100, 90);
		Meowro.getInstance().getBatch().end();
		
		if (InputManager.getInstance().getInputMainMenu() == 4) {
			Meowro.getInstance().setScore(0);
			Meowro.getInstance().setScreen(new GameScreen());
		}
		if (InputManager.getInstance().getInputMainMenu() == 1) {
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
		Meowro.getInstance().dispose();
	}

}
