

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KeyListenerTeste extends JFrame 
						implements KeyListener {

	String msg;
	JLabel status = new JLabel();

	public KeyListenerTeste() {
		this.addKeyListener(this);		
		this.add(status,BorderLayout.SOUTH);
	}
	@Override
	public void keyPressed(KeyEvent event) {
		status.setText("Tecla pressionada: " + event.getKeyChar());
		if(event.getKeyCode() == KeyEvent.VK_F5)
        JOptionPane.showMessageDialog(this, "F5 pressed");
	}
	@Override
	public void keyReleased(KeyEvent event) {
		status.setText("Tecla Solta:    " + event.getKeyChar());
	}
	@Override
	public void keyTyped(KeyEvent event) {
		status.setText("Tecla Tipada:    " + event.getKeyChar());
	}
	public static void main(String[] args) {
		KeyListenerTeste janela = new KeyListenerTeste();
		janela.setSize(400, 100);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

	}
}
