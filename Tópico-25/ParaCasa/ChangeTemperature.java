import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeTemperature extends JFrame implements ActionListener{

	private JLabel jlabel, jlabel2;
	private Double c = -17.7778, f;
	protected JTextField jtext;
	private JButton jbutton;

	public ChangeTemperature(String titulo) {
		super(titulo);
		setLayout(new FlowLayout());

		jlabel = new JLabel("Fahrenheit:");
		jtext = new JTextField("0");
		jbutton = new JButton("Converter");
		jlabel2 = new JLabel(c + " Celsius");

		add(jlabel);
		add(jtext);
		add(jbutton);
		add(jlabel2);

		jtext.addActionListener(this);
		jbutton.addActionListener(this);

	}

	public Double transformar(Double f) {
		c = (5.0/9.0) * (f-32.0);
		return c;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//System.out.println(jtext.getText());
		f = transformar(Double.parseDouble(jtext.getText()));
		jlabel2.setText(f + " Fahrenheit");
	}

		
	public static void main(String[] args) {
		ChangeTemperature changeTemperature = new ChangeTemperature("Teste de Janela");
		changeTemperature.setSize(300,130);
		changeTemperature.setVisible(true);
	}


}
