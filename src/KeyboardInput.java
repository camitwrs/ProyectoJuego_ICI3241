import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter {
	
	GameHandler handler;
	
	public KeyboardInput(GameHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0 ;i < handler.object.size(); i++) {
			GameObject tempGameObject = handler.object.get(i);
			
			if(tempGameObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) handler.setUp(true);
				if(key == KeyEvent.VK_S) handler.setDown(true);
				if(key == KeyEvent.VK_A) handler.setLeft(true);
				if(key == KeyEvent.VK_D) handler.setRight(true);
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0 ;i < handler.object.size(); i++) {
			GameObject tempGameObject = handler.object.get(i);
			
			if(tempGameObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) handler.setUp(false);
				if(key == KeyEvent.VK_S) handler.setDown(false);
				if(key == KeyEvent.VK_A) handler.setLeft(false);
				if(key == KeyEvent.VK_D) handler.setRight(false);
			}
		}	
	}
}
