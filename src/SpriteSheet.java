import java.awt.image.BufferedImage;

/*
 * Consigue la imagen de los sprites y la corta.
 */
public class SpriteSheet {
	
	private BufferedImage img;
	
	public SpriteSheet(BufferedImage img) {
		this.img = img;
	}
	
	public BufferedImage cropImage(int col, int row, int width, int height) { 
		// Sprites 32x32
		return img.getSubimage((col*32)-32, (row*32)-32, width, height);
	}
}
