package ProvaMensalMarinGotica_Bimestre2;

import java.awt.Dimension;
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

	private JButton jbuttonBuscar;

	ArrayList<Aluno> listaDeAlunos = new ArrayList<Aluno>();

	// define o arquivo csv a ser lido
	String file = "./dados.csv";

	public Cadastro(String titulo) {
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
		
		OpenTXTFile txt = new OpenTXTFile();

		listaDeAlunos = txt.LerTXT(file);

		jtextNome.setText(getNomeByNumero(1));
		jtextGrupo.setText(getGrupoByNumero(1) + "");
		jtextNumero.setText("1");
	}

	private class Escutador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {			
			//Ações ao pressionarem os botões.
			if(jtextNumero.getText().isEmpty()){
				jtextNome.setText("");
				jtextGrupo.setText("");
			}else{	
				int numero = Integer.parseInt(jtextNumero.getText());
				jtextNome.setText(getNomeByNumero(numero));
				jtextGrupo.setText(getGrupoByNumero(numero) + "");
			}
			
			
		}

	}
	
	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro("Cadastro");
		cadastro.pack();
		cadastro.setSize(210,150);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.setVisible(true);
	}

	public String getNomeByNumero(int numero){
		for(Aluno a : listaDeAlunos){
			if(numero == a.getNumero()){
				return a.getNome();
			}
		}
		return "Não Encontrado!";
	}

	public int getGrupoByNumero(int numero){
		for(Aluno a : listaDeAlunos){
			if(numero == a.getNumero()){
				return a.getGrupo();
			}
		}
		return 999999999;
	}
}

class OpenTXTFile {

    public ArrayList<Aluno> LerTXT(String file) {
      Scanner scanner;
      File txt = new File(file);
      ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
  
      try {
        scanner = new Scanner(txt);
        scanner.nextLine();
  
        while (scanner.hasNextLine()) {
          String[] line = scanner.nextLine().split(",");
            int numero = Integer.parseInt(line[0]);
            String nome = line[1];
            int grupo = Integer.parseInt(line[2]);
          
          Aluno aluno = new Aluno(numero, nome, grupo);
		  listaDeAlunos.add(aluno);
        }
        scanner.close();
      } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
      }
      return listaDeAlunos;
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