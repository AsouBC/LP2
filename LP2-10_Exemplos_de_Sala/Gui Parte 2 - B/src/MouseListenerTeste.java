

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerTeste extends JFrame implements MouseListener,
		MouseMotionListener {

	String msg;
	JLabel status = new JLabel();
	
	public MouseListenerTeste() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.add(status,BorderLayout.SOUTH);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		msg = "Clicado - Botão: " + e.getButton() + " X: " + e.getX() + " Y:"
				+ e.getY();
		this.setTitle(msg);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		msg = "Entrou - Botão: " + e.getButton() + " X: " + e.getX() + " Y:"
				+ e.getY();
		this.setTitle(msg);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		msg = "Saiu - Botão: " + e.getButton() + " X: " + e.getX() + " Y:"
				+ e.getY();
		this.setTitle(msg);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		msg = "Pressionou - Botão: " + e.getButton() + " X: " + e.getX()
				+ " Y:" + e.getY();
		this.setTitle(msg);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		msg = "Soltou - Botão: " + e.getButton() + " X: " + e.getX() + " Y:"
				+ e.getY();
		this.setTitle(msg);
	}
	// MotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
		msg = "Arrastado - Botão: " + e.getButton() + " X: " + e.getX() + " Y:"
				+ e.getY();
		status.setText(msg);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		msg = "Movido - Botão: " + e.getButton() + " X: " + e.getX() + " Y:"
				+ e.getY();
		status.setText(msg);
	}
	
	public static void main(String[] args) {
		MouseListenerTeste janela = new MouseListenerTeste();
		janela.setSize(300, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

	}

}
