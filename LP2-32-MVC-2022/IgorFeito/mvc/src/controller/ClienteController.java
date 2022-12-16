package controller;

import dao.ClienteDAO;
import dao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import view.JanelaPrincipal;

public class ClienteController implements ClienteDAO, ActionListener{

    private JanelaPrincipal view;
    private Cliente model;
    private Conexao con;

    private int indice = 0;

    public ClienteController(Cliente model, JanelaPrincipal view, Conexao con)
    {
        this.view = view;
        this.model = model;
        this.con = con;

        carregaCON();

        adicionarAction();

        carregaDadosNaJanela();
    }

    public void carregaCON()
    {
        con.abrirConexao();
        con.carregarDados();
    }

    public void testaLimites() {
		if(indice == 0){
			view.btnAnterior.setEnabled(false);
			view.btnProximo.setEnabled(true);
			
		}else if(indice  == model.getClientes().size()-1) {		
			view.btnAnterior.setEnabled(true);
			view.btnProximo.setEnabled(false);		
		}else {
			view.btnAnterior.setEnabled(true);
			view.btnProximo.setEnabled(true);
		}
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(view.btnProximo.getActionCommand()) ) {
			indice++;
		}else {
			indice--;
		}
		carregaDadosNaJanela();	
	}

    public void carregaDadosNaJanela() {		
		Cliente c = model.getClientes().get(indice);
		view.txtNome.setText(c.getNome());
		view.txtMatricula.setText(c.getMatricula());
		view.txtSerie.setText(c.getSerie());
		view.txtCurso.setText(c.getCurso());
        view.setTitle(indice + 1 + " - " +  c.getNome());
		testaLimites();
	}

    private void adicionarAction(){
        view.btnProximo.addActionListener(this);
        view.btnAnterior.addActionListener(this);
    }
}
