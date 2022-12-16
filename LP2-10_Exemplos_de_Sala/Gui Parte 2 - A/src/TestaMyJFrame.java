

import javax.swing.JFrame;

public class TestaMyJFrame {
	public static void main(String[] args) {
		
		MyJFrame myJFrame = new MyJFrame("Minha nova Janela");		
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJFrame.setSize(350, 100);
		myJFrame.setVisible(true);
	}
}
