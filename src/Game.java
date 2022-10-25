import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/*
 * Clase Principal.
 * Áquí esta el GameLoop, Updating, Rendering, etc.
 */
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;
	private GameHandler handler;
	private Camera camera;
	
	private BufferedImage level = null;
	
	public Game(){
		new Window(1000,563,"Meowro",this);
		
		// Solo 1 instancia siempre. No se modifica nunca, se va traspasando entre clases.
		handler = new GameHandler();
		camera = new Camera(0, 0);
		
		this.addKeyListener(new KeyboardInput(handler));
		this.addMouseListener(new MouseInput(handler, camera));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/meowro_level.png");
		
		loadLevel(level);
		
		start();
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// Game Loop de @ Notch Minecraft Developer 
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
		
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	public void tick() { // Actualiza
		// ¿Cual GameObject es nuestro player?
		// Recorre todos los objetos del juego, buscando cuál es nuestro Player
		// y lo pone en los parámetros de nuestra cámara que necesitamos usar.
		for(int i = 0 ; i < handler.object.size() ; i++) {
			if(handler.object.get(i).getId() == ID.Player) {
				camera.update(handler.object.get(i));
			}
		}
		
		handler.update();
	}
	
	public void render() { // Dibuja
		BufferStrategy bs = this.getBufferStrategy(); // Pre-carga fps
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		// Convertir a graphics 2d
		Graphics2D g2d = (Graphics2D) g;
	
		///////////////TODO LO DE AQUÍ ES DIBUJADO EN PANTALLA/////////////////
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 1000, 563);
		
		// Limites de translate: Permiten que la cámara sea "traducida", movible.
		g2d.translate(-camera.getX(), -camera.getY());
	
		handler.render(g); // Renderiza todos los objetos
		
		g2d.translate(camera.getX(), camera.getY());
		
		///////////////////////////////////////////////
		
		g.dispose();
		bs.show();
	}
	
	// Cargando el level
	private void loadLevel(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int xx = 0 ; xx < width ; xx++) {
			for(int yy = 0 ; yy < height ; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255)
					handler.addObject(new Block(xx*32, yy*32, ID.Block, handler));
				if(blue == 255)
					handler.addObject(new Player(xx*32, yy*32, ID.Player, handler));
			}
		}
	}
	
	public static void main(String args[]) {
		new Game();
	}

}
