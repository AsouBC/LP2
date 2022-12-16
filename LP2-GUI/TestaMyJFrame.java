

import javax.swing.JFrame;

public class TestaMyJFrame {
	public static void main(String[] args) {
		
		CelsiusToFahrenheit myJFrame = new CelsiusToFahrenheit("Minha nova Janela");		
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJFrame.setSize(350, 100);
		myJFrame.setVisible(true);
	}
}
