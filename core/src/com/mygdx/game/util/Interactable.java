package com.mygdx.game.util;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.characters.Entity;

public interface Interactable {
	void interaction(Entity e);
	Rectangle getRect();
}
