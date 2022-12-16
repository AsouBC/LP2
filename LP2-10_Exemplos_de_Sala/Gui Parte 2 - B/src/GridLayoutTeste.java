

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTeste extends JFrame {

	public GridLayoutTeste() {
		Container panel = this.getContentPane();
		int linhas = 3, colunas = 2;
		int distanciaV = 10, distanciaH = 20;

		GridLayout grid = new GridLayout(
				linhas, colunas, 
				distanciaH, distanciaV);

		for (int i = 0; i < 6; i++) {
			panel.add(new JButton("Botão" + i));
		}
		
		panel.setLayout(grid);
	}
	public static void main(String[] args) {
		GridLayoutTeste janela = new GridLayoutTeste();
		janela.setSize(300, 130);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

	}
}
