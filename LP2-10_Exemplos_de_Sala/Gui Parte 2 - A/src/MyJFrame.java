
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyJFrame extends JFrame {

	private JLabel jlabel;
	private JTextField jtext;
	private JButton jbutton;

	public MyJFrame(String titulo) {
		super(titulo);
		setLayout(new FlowLayout());

		jlabel = new JLabel("Insira seu nome:");
		jtext = new JTextField("An�nimo");
		jbutton = new JButton("OK");

		add(jlabel);
		add(jtext);
		add(jbutton);

		TextFieldHandler handler = new TextFieldHandler();

		jtext.addActionListener(handler);
		jbutton.addActionListener(handler);

	}

	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {			
			
			if (event.getSource()==jtext) {
				JOptionPane.showMessageDialog(MyJFrame.this,
						"Caixa de texto: " + event.getActionCommand());	
			} else {
				JOptionPane.showMessageDialog(MyJFrame.this,
						"Bot�o: " + event.getActionCommand());
			}
			
		}

	}
	
	public static void main(String[] args) {
		MyJFrame my = new MyJFrame("Ois");
		//my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//my.setSize(350, 100);
		my.setVisible(true);
	}

}
