import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
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
	private SpriteSheet ss;
	
	public int ammo = 100;
	public int hp = 100;
	
	private BufferedImage sprite_sheet = null;
	private BufferedImage level = null;
	private BufferedImage floor = null;
	
	public Game(){
		new Window(1000,563,"Meowro",this);
		
		// Solo 1 instancia siempre. No se modifica nunca, se va traspasando entre clases.
		handler = new GameHandler();
		camera = new Camera(0, 0);
		
		this.addKeyListener(new KeyboardInput(handler));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/meowro_level.png");
		
		sprite_sheet = loader.loadImage("/meowro_spriteSheet.png");
		ss = new SpriteSheet(sprite_sheet);
		
		floor = ss.cropImage(4, 2, 32, 32);
		
		this.addMouseListener(new MouseInput(handler, camera, this));
		
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
		// Game Loop de autor @ Notch, Minecraft Developer 
		
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
		
		// Limites de translate: Permiten que la cámara sea "traducida", movible.
		g2d.translate(-camera.getX(), -camera.getY());
	
		// Dibuja todos los tiles del piso
		for(int xx = 0 ; xx < 30*72 ; xx+=32) {
			for(int yy = 0 ; yy < 30*72 ; yy+=32) {
				g.drawImage(floor, xx, yy, null);
			}
		}
		
		handler.render(g); // Renderiza todos los objetos
		
		g2d.translate(camera.getX(), camera.getY());
		
		// Dibujar barra de vida en pantallaS
		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 10);
		g.setColor(Color.green);
		g.fillRect(5, 5, hp*2, 10);
		g.setColor(Color.green);
		g.drawRect(5, 5, 200, 10);
		
		// Dibuja el texto en pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Joystix Monospace", Font.PLAIN, 15));
		g.drawString("Municion: " + ammo, 5, 32);
		
		///////////////////////////////////////////////////////////////////////////////
		
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
				
				// Creación y detección de los tipos de objetos según el color en el mapa
				if(red == 255 && green == 0 & blue == 0)
					handler.addObject(new Block(xx*32, yy*32, ID.Block, handler, ss));
				if(blue == 255 && green == 0 && red == 0)
					handler.addObject(new Player(xx*32, yy*32, ID.Player, handler, this, ss));
				if(green == 255 && red == 0 && blue == 0)
					handler.addObject(new Mouse(xx*32, yy*32, ID.Mouse, handler, ss));
				if(green == 255 && blue == 255 && red == 0)
					handler.addObject(new AmmoBox(xx*32, yy*32, ID.AmmoBox, handler, ss));
			}
		}
	}
	
	public static void main(String args[]) {
		new Game();
	}

}
