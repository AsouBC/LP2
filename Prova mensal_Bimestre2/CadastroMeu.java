import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/***
 * Classe com escutador externo
 */

/*
Feita usando a prova do Igor como referência hehe.
Vou estudar arquivo usando essa prova e outras coisas.
Até eu conseguir fazer pensando sozinho.
*/

public class CadastroMeu extends JFrame {

	//Define componentes da janela.
	private JLabel jLabelNumero;
	private JLabel jLabelNome;
	private JLabel jLabelGrupo;

	protected JTextField jtextNumero;
	protected JTextField jtextNome;
	protected JTextField jtextGrupo;

	private JButton jbuttonBuscar;

	ArrayList<Aluno> listaDeAlunos = new ArrayList<Aluno>();
	
	String arquivo = "./dados.csv";
	
	public CadastroMeu(String titulo) {
		super(titulo);

		setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Inicializa componentes da janela.
		jLabelNumero = new JLabel("Buscar" );		
		jLabelNome = new JLabel("Nome" );		
		jLabelGrupo = new JLabel("Grupo");
		
		jtextNumero = new JTextField("0",10);
		jtextNome = new JTextField(10);
		jtextGrupo = new JTextField(10);

		jbuttonBuscar = new JButton("Buscar");
		jbuttonBuscar.setPreferredSize(new Dimension(180,18));
		


		//Adiciona componentes na janela.
		this.add(jLabelNumero);		
		this.add(jtextNumero);
		this.add(jbuttonBuscar);

		this.add(jLabelNome);		
		this.add(jtextNome);

		this.add(jLabelGrupo);
		this.add(jtextGrupo);
				
		
		

		//Cria o escutador
		Escutador handler = new Escutador();

		//Adiciona o escutador a cada botão.
		jbuttonBuscar.addActionListener(handler);

		//Logica de inicialização aqui.
		// ...

		AbrirCSV abrir = new AbrirCSV();

		listaDeAlunos = abrir.LerCSV(arquivo);

		jtextNome.setText(pegaNomePorNumero(1));
		jtextGrupo.setText(pegaGrupoPorNumero(1) + "");
		jtextNumero.setText("1");
			
	}

	private class Escutador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(jtextNumero.getText().isEmpty()){
				jtextNome.setText("");
				jtextGrupo.setText("");
			}else{	
				int numero = Integer.parseInt(jtextNumero.getText());
				jtextNome.setText(pegaNomePorNumero(numero));
				jtextGrupo.setText(pegaGrupoPorNumero(numero) + "");
			}
			
		}

	}
	public String pegaNomePorNumero(int numero){
		for(Aluno al : listaDeAlunos){
			if(numero == al.getNumero()){
				return al.getNome();
			}
		}
		return "Não existe hehe!";
	}

	public int pegaGrupoPorNumero(int numero){
		for(Aluno al : listaDeAlunos){
			if(numero == al.getNumero()){
				return al.getGrupo();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		CadastroMeu cadastro = new CadastroMeu("Cadastro");
		cadastro.pack();
		cadastro.setSize(210,150);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.setVisible(true);
	}

}

class Aluno{
	private int numero, grupo;
	private String nome;

	  public Aluno(int numero, String nome, int grupo){
		  this.numero = numero;
		  this.nome = nome;
		  this.grupo = grupo;
	  }

	public int getNumero(){
		return this.numero;
	}

	public int getGrupo(){
		return this.grupo;
	}

	public String getNome(){
		return this.nome;
	}
}

class AbrirCSV{

	public ArrayList<Aluno> LerCSV(String arquivo){
		File text = new File(arquivo);
      	ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
		Scanner sc;

		try{
			sc = new Scanner(text);
			sc.nextLine();
			while(sc.hasNextLine()){
				String[] line = sc.nextLine().split(",");
            	int numero = Integer.parseInt(line[0]);
            	String nome = line[1];
            	int grupo = Integer.parseInt(line[2]);
          
          		Aluno aluno = new Aluno(numero, nome, grupo);
		  		listaDeAlunos.add(aluno);
			}
			
        sc.close();
      }catch (Exception e){
        System.out.println("Erro: " + e.getMessage());
      }
      return listaDeAlunos;
    }
}