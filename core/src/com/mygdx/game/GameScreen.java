package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.ObjectManager;
import com.mygdx.game.managers.ResourceManagerSingleton;
import com.mygdx.game.util.Constants;

public class GameScreen implements Screen{

	ObjectManager obManager;
	Texture fondo;
	
	public GameScreen() {
		
		ResourceManagerSingleton.getInstance().loadAllResources();
		
		obManager = new ObjectManager();
		
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
		BaseGameSingleton.getInstance().getBatch().begin();
		BaseGameSingleton.getInstance().getBatch().setColor(Color.WHITE);
		BaseGameSingleton.getInstance().getBatch().draw(fondo, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		BaseGameSingleton.getInstance().getBatch().end();
		//Meowro.getInstance().getCamera().update();
		//Meowro.getInstance().getBatch().setProjectionMatrix(Meowro.getInstance().getCamera().combined); // Representa la vista combinada y la matriz de proyeccion.
		// Actualiza
		obManager.update(delta);
		// Dibuja
		obManager.render();
		renderHud(); 
		
	}
	
    private void renderHud() {
    	BaseGameSingleton.getInstance().getBatch().begin();
    	BaseGameSingleton.getInstance().getFont().setColor(Color.BLACK);
    	BaseGameSingleton.getInstance().getFont().draw(BaseGameSingleton.getInstance().getBatch(), "Puntos: " + BaseGameSingleton.getInstance().getScore(), 10, Constants.SCREEN_HEIGHT-10);
    	BaseGameSingleton.getInstance().getBatch().end();
    	//Barra Vida Transparencia
        Gdx.gl.glEnable(GL30.GL_BLEND);
        Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
        BaseGameSingleton.getInstance().getSR().begin(ShapeType.Filled);
        BaseGameSingleton.getInstance().getSR().setColor(128, 128, 128, 0.5f);
        BaseGameSingleton.getInstance().getSR().rect(15,15,200,32);  
        BaseGameSingleton.getInstance().getSR().setColor(0, 0, 255, 0.5f);
        BaseGameSingleton.getInstance().getSR().rect(15,15,(200*obManager.getPlayer().getHp()*0.001f),32);
        BaseGameSingleton.getInstance().getSR().end();
        Gdx.gl.glDisable(GL30.GL_BLEND);
        
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
