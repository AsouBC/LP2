
import javax.swing.JOptionPane;

public class MyJOption {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog(null, "Qual seu nome?",
				"Teste de Caixas de Di�logo", JOptionPane.QUESTION_MESSAGE);

		JOptionPane.showMessageDialog(null, "Ol� " + nome,
				"T�tulo da Mensagem", JOptionPane.INFORMATION_MESSAGE);

	}

}
