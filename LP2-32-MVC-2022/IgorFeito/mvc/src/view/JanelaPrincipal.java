package view;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame{
    //janela que contém tudo

	private final int LARGURA_TELA = 320;
	private final int ALTURA_TELA = 180;

    public JLabel lblMatricula, lblNome, lblSerie, lblCurso;
	public JTextField txtMatricula, txtNome, txtSerie, txtCurso;
	public JButton btnProximo, btnAnterior;

    public JanelaPrincipal() {

		setTitle("MVC - Alunos");
		setSize(new Dimension(LARGURA_TELA, ALTURA_TELA));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*this.setResizable(false);*/

        repaint();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		init();
	}

    private void init()
    {
        lblMatricula = new JLabel("Matricula");
		txtMatricula = new JTextField(20);

		lblNome = new JLabel("Nome");
		txtNome = new JTextField(22);

		lblSerie = new JLabel("Serie");
		txtSerie = new JTextField(3);

		lblCurso = new JLabel("Curso");
		txtCurso = new JTextField(15);

		btnProximo = new JButton("Next");
		btnProximo.setPreferredSize(new Dimension(130, 26));
		
		btnAnterior = new JButton("Previus");
		btnAnterior.setPreferredSize(new Dimension(130, 26));
		// this.setLayout();

		Box painel = Box.createVerticalBox();

		Component box = Box.createRigidArea(new Dimension(30, 30));

		// Container painel = new JPanel(new FlowLayout());

		painel.add(novaLinha(box, lblMatricula, txtMatricula));
		painel.add(novaLinha(lblNome, txtNome));
		painel.add(novaLinha(lblSerie, txtSerie, lblCurso, txtCurso));

		painel.add(novaLinha(btnAnterior, box, btnProximo));

		this.add(painel);
    }

    private JPanel novaLinha(Component... componentes) {
		return novaLinha(FlowLayout.TRAILING, componentes);
	}

    private JPanel novaLinha(int alinhamento, Component... componentes) {
		// alinhamento= FlowLayout.TRAILING;
		JPanel painel = new JPanel(new FlowLayout(alinhamento, 3, 2));
		for (Component component : componentes) {
			painel.add(component);
		}
		return painel;
	}
}
