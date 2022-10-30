package com.mygdx.game.characters;

import com.badlogic.gdx.math.Rectangle;

public interface Interactable {
	void interaction(Entity e);
	Rectangle getRect();
}
