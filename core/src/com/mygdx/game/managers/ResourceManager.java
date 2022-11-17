package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class ResourceManager {

	private static ResourceManager instance = null;
	
    // TextureAtlas con los sprites del game
    private TextureAtlas atlas;
   /* Texture player;
    TextureRegion tRPlayer;
    Sprite sPlayer;
    TextureRegionDrawable tRDPlayer;
    */
    /**
     * Carga en memoria todos los recursos (gráficos, sonidos y música)
     */
    public void loadAllResources() {
        
    	atlas = new TextureAtlas(Gdx.files.internal("Meowro.txt")); 
    	 /*final TextureRegionDrawable a = new TextureRegionDrawable();
    	 
    	 tRPlayer = atlas.findRegion("wolfFront");
    	 player = tRPlayer.getTexture();
    	 tRDPlayer.draw(player);
    	 */
        /*sounds = new HashMap<>();
        sounds.put("waterdrop", Gdx.audio.newSound(Gdx.files.internal("sounds/waterdrop.wav")));
        sounds.put("rock", Gdx.audio.newSound(Gdx.files.internal("sounds/rock.mp3")));
        sounds.put("frog", Gdx.audio.newSound(Gdx.files.internal("sounds/frog.mp3")));

        musics = new HashMap<>();
        musics.put("bso", Gdx.audio.newMusic(Gdx.files.internal("sounds/undertreeinrain.mp3")));*/
    	
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