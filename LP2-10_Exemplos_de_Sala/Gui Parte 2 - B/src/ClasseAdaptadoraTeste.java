

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class ClasseAdaptadoraTeste extends JFrame{

	public ClasseAdaptadoraTeste() {
		this.addMouseMotionListener(new MouseAdaptadora());
	}

	class MouseAdaptadora extends MouseAdapter{

		@Override
		public void mouseDragged(MouseEvent e) {
			String msg = "X :" + e.getX() + " Y: " + e.getY() ;
			ClasseAdaptadoraTeste.this.setTitle(msg);
		}		
	}
	
	public static void main(String[] args) {
		ClasseAdaptadoraTeste janela = new ClasseAdaptadoraTeste();
		janela.setSize(400,400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

}
