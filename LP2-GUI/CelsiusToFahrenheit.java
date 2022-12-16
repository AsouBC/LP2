import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Fórmula: C -> C = (c*9)/5 + 32 = F
//Buguei, farei depois em casa

public class CelsiusToFahrenheit extends JFrame implements ActionListener{

	private JLabel jlabel, jlabel2;
	private Double f = 32.0, c;
	protected JTextField jtext;
	private JButton jbutton;

	public CelsiusToFahrenheit(String titulo) {
		super(titulo);
		setLayout(new FlowLayout());

		jlabel = new JLabel("Celsius:");
		jtext = new JTextField("0");
		jbutton = new JButton("Converter");
		jlabel2 = new JLabel(f + " Fahrenheit");

		add(jlabel);
		add(jtext);
		add(jbutton);
		add(jlabel2);

		jtext.addActionListener(this);
		jbutton.addActionListener(this);

	}

	public Double transformar(Double c) {
		f = (c * 1.8) + 32;
		return f;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		f = transformar(Double.parseDouble(jtext.getText()));
		jlabel2.setText(f + " Fahrenheit");
	}

		
	public static void main(String[] args) {
		CelsiusToFahrenheit my = new CelsiusToFahrenheit("Teste de Janela");
		my.setSize(300,130);
		my.setVisible(true);
	}


}
