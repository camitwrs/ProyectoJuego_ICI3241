package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class ResourceManager {

	private static ResourceManager instance = null;
	
    // TextureAtlas con los sprites del game
    private TextureAtlas atlas;

    public void loadAllResources() {
        
    	atlas = new TextureAtlas(Gdx.files.internal("Meowro.txt")); 
    	
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    public void dispose() {

        atlas.dispose();
    }
    
    public static ResourceManager getInstance() {
		if (instance == null)
			instance = new ResourceManager();
		
		return instance;
	}
    

}