import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/***
 * Classe com escutador externo
 */
public class Cadastro extends JFrame {

	//Define componentes da janela.
	private JLabel jLabelNumero;
	private JLabel jLabelNome;
	private JLabel jLabelGrupo;

	protected JTextField jtextNumero;
	protected JTextField jtextNome;
	protected JTextField jtextGrupo;

	private JButton jbuttonAnterior;
	private JButton jbuttonProximo;

	ArrayList<Aluno> alunos;
	int indice = 0;
	
	public Cadastro(String titulo) {
		super(titulo);

		setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Inicializa componentes da janela.
		jLabelNumero = new JLabel("Número" );
		jLabelNome = new JLabel("Nome" );
		jLabelGrupo = new JLabel("Grupo");
		
		jtextNumero = new JTextField(10);
		jtextNome = new JTextField(10);
		jtextGrupo = new JTextField(10);

		jbuttonAnterior = new JButton("Anterior");
		jbuttonProximo= new JButton("Próximo");


		//Adiciona componentes na janela.
		this.add(jLabelNumero);
		this.add(jtextNumero);
		
		this.add(jLabelNome);		
		this.add(jtextNome);

		this.add(jLabelGrupo);
		this.add(jtextGrupo);
				
		this.add(jbuttonAnterior);
		this.add(jbuttonProximo);

		//Cria o escutador
		Escutador handler = new Escutador();

		//Adiciona o escutador a cada botão.
		jbuttonAnterior.addActionListener(handler);
		
		jbuttonProximo.addActionListener(handler);


		//Logica de inicialização aqui.
		// ...
		lerArquivo lerarq = new lerArquivo();
		alunos = lerarq.ler();

		atualizar();

	}

	private class Escutador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {			

			//Ações ao pressionarem os botões.

			if (event.getSource()==jbuttonAnterior) {
				indice--;

			}else if (event.getSource()==jbuttonProximo) {
				indice++;

			}
			if(indice >= alunos.size()) {
				indice = 0;
			}else if(indice < 0) {
				indice = alunos.size() -1;
			}
			atualizar();
			
		}

	}
	public void atualizar(){
		jtextNumero.setText(alunos.get(indice).getNumero() + "");
		jtextNome.setText(alunos.get(indice).getNome());
		jtextGrupo.setText(alunos.get(indice).getGrupo() + "");
	}
	
	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro("Cadastro");
		cadastro.pack();
		cadastro.setSize(210,150);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.setVisible(true);
	}

}

class lerArquivo{
	public ArrayList<Aluno> ler(){
		ArrayList<Aluno> listaAluno = new ArrayList<>();
		Scanner sc;
		int numero, grupo;
		String nome;
		File file = new File("dados.csv");
		try{
			sc = new Scanner(file);
			sc.nextLine();
			while(sc.hasNextLine()){
				String palavras[] = sc.nextLine().split(",");
				numero = Integer.parseInt(palavras[0]);
				grupo = Integer.parseInt(palavras[2]);
				nome = palavras[1];
				Aluno aluno = new Aluno(numero, grupo, nome);
				listaAluno.add(aluno);
			}
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
		return listaAluno;
		
	}

}

class Aluno{
	private int numero, grupo;
	private String nome;

	public Aluno(int numero, int grupo, String nome){
		this.numero = numero;
		this.grupo = grupo;
		this.nome = nome;
	}

	public int getNumero(){
		return numero;
	}

	public int getGrupo(){
		return grupo;
	}

	public String getNome(){
		return nome;
	}
}


