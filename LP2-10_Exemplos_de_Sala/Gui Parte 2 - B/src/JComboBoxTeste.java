

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class JComboBoxTeste extends JFrame{

	JLabel label;
	JComboBox<String> jCombo;

	public JComboBoxTeste() throws HeadlessException {
	
		this.setLayout(new FlowLayout(
				FlowLayout.CENTER, 10, 10));

		String nomes[] = {"João","Maria", "José"};
		
		jCombo = new JComboBox(nomes);		

		label = new JLabel();

		this.add(jCombo);
		this.add(label);

		jCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox objeto = (JComboBox) e.getSource();
				
				System.out.println("Item selecionado: " + objeto.getSelectedItem());

				String mensagem = "Selcionados:  ";

				if (objeto.getSelectedItem().toString() == "João") {
					mensagem += "João";
				} else if (objeto.getSelectedItem().toString() == "Maria") {
					mensagem += "Maria";
				} else if (objeto.getSelectedItem().toString() == "José") {
					mensagem += "José";
				}

				label.setText(mensagem);				
			}
		});
		
	insereFirulas();
	}
	
	private void insereFirulas() {
		jCombo.setPreferredSize(new Dimension(130, 30));
		label.setPreferredSize(new Dimension(150, 30));
		
		label.setBorder(BorderFactory.createBevelBorder(
				BevelBorder.RAISED , Color.BLUE,
				Color.GREEN));				
	}

	public static void main(String[] args) {
		JComboBoxTeste janela = new JComboBoxTeste();
		janela.setSize(300, 130);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

}
