

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JcheckBoxTeste extends JFrame 
				 {

	JLabel label;
	JCheckBox chkJoao;
	JCheckBox chkMaria;
	JCheckBox chkJose;

	public JcheckBoxTeste() throws HeadlessException {
	
		this.setLayout(new FlowLayout(
				FlowLayout.CENTER, 10, 10));

		chkJoao = new JCheckBox("João");
		chkJose = new JCheckBox("José");
		chkMaria = new JCheckBox("Maria");

		label = new JLabel();

		
		
		this.add(chkJoao);
		this.add(chkJose);
		this.add(chkMaria);

		this.add(label);
Escutador escutador = new Escutador();
		
		
		chkJoao.addItemListener(escutador);
		chkJose.addItemListener(escutador);
		chkMaria.addItemListener(escutador);
	}

	

	public static void main(String[] args) {
		JcheckBoxTeste janela = new JcheckBoxTeste();
		janela.setSize(300, 130);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	

class Escutador implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox objeto = (JCheckBox) e.getSource();
		System.out.println("Item selecionado: " + 
				objeto.getText());
		
		String mensagem = "Selcionados: ";

		if (chkJoao.isSelected()) {
			mensagem += "João,";
		}
		if (chkMaria.isSelected()) {
			mensagem += "Maria,";
		}
		if (chkJose.isSelected()) {
			mensagem += "José";
		}
		if (!chkJose.isSelected() && !chkJoao.isSelected()
				&& !chkMaria.isSelected()) {
			mensagem += "Ninguém.";
		}
		label.setText(mensagem);		
	}
	
}
	
}

