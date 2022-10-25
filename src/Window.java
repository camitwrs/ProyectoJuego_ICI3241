import java.awt.Dimension;

import javax.swing.JFrame;

// Ventana de 1000 x 563
public class Window {

	public Window(int ancho, int alto, String titulo, Game game) {
		JFrame frame = new JFrame(titulo);
		
		frame.setPreferredSize(new Dimension(ancho,alto));
		frame.setMaximumSize(new Dimension(ancho,alto));
		frame.setMinimumSize(new Dimension(ancho,alto));
		
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // centro de la ventana
		frame.setVisible(true);
	}
}
