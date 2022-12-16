

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class JPanelTeste extends JFrame{

	public JPanelTeste() {
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		
		JPanel fundo = (JPanel)this.getContentPane();
		fundo.setLayout(new BorderLayout());
		
		JPanel norte = new JPanel(layout);
		JPanel sul = new JPanel(layout);
		JPanel centro = new JPanel();
		centro.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED , Color.BLUE,Color.GREEN));
		
		centro.setLayout(
				new BoxLayout(centro, BoxLayout.Y_AXIS));
			
		insereBotoes(3,norte, "Norte");
		insereBotoes(4,sul, "Sul");
		insereBotoes(6,centro, "Centro");
		
		fundo.add(norte,BorderLayout.NORTH);
		fundo.add(sul,BorderLayout.SOUTH);
		fundo.add(centro,BorderLayout.CENTER);				
	}

	private void insereBotoes(
			int n, JPanel painel, String texto) {		
		for (int i = 0; i < n; i++) {		 
			JButton button = new JButton(texto + i );
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
			painel.add(button);
		}		
	}

	public static void main(String[] args) {
		JPanelTeste janela = new JPanelTeste();
		janela.setSize(300, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

}
