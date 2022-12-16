

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTeste extends JFrame implements ListSelectionListener {

	JLabel label;
	private JList <String>list;
	private DefaultListModel<String> listModel;

	public JListTeste() throws HeadlessException {

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		listModel = new DefaultListModel<String>();
		listModel.addElement("Azul");
		listModel.addElement("Amarelo");
		listModel.addElement("Vermelho");
		listModel.addElement("Preto");
		listModel.addElement("Branco");
		listModel.addElement("Cinza");
		listModel.addElement("Rosa");
		
		
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);	
		list.setVisibleRowCount(5);
				
		list.addListSelectionListener(this);
			
		JScrollPane listScrollPane = new JScrollPane(list);
		//listScrollPane.setVisible(true);
		label = new JLabel();

		this.add(listScrollPane);
		this.add(label);

		insereFirulas();
	}
 
	@Override
	public void valueChanged(ListSelectionEvent evento) {
		
		String mensagem = list.getSelectedValue();
		
		Color cor = this.getBackground();
		
		switch (mensagem) {
		case "Azul":
			cor = Color.blue;
			break;
		case "Amarelo":
			cor = Color.yellow;
			break;		
		case "Vermelho":
			cor = Color.red;
			break;			
		case "Preto":
			cor = Color.black;
			break;
		case "Branco":
			cor = Color.white;
			break;
		case "Cinza":
			cor = Color.gray;
			break;
		case "Rosa":
			cor = Color.pink;
			break;		
		}		
		JListTeste.this.getContentPane().setBackground(cor);
		label.setText(mensagem);
	}
	
	
	private void insereFirulas() {
		list.setPreferredSize(new Dimension(200,130));		
		label.setPreferredSize(new Dimension(150, 30));
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,
				Color.BLUE, Color.GREEN));
	}

		
	public static void main(String[] args) {
		JListTeste janela = new JListTeste();
		janela.setSize(300, 200);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
}