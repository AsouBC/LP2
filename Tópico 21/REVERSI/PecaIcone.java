package REVERSI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;

public class PecaIcone extends JButton{
    private static int tamanho = 64;
    private Estado estado;
    private Image i1, i2;

    public PecaIcone(){
        super();
        setContentAreaFilled(false);
        estado = Estado.VAZIO;
        i1 = new ImageIcon("Sprites/BobEsponja.jpg").getImage();
        i2 = new ImageIcon("Sprites/Hulk.jpg").getImage();
    }

    public void setEstado(Estado e){
        estado = e;
    }

    public Dimension getMaximumSize(){
        return getPreferredSize();
    }
    public Dimension getMinimumSize(){
        return getPreferredSize();
    }
    public Dimension getPreferredSize(){
        return new Dimension(tamanho, tamanho);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //Não preenchemos botões vazios.
        if(estado != Estado.VAZIO){
            if(estado == Estado.BRANCO) g2d.drawImage(i1, -150, -150, null);
            else if(estado == Estado.PRETO) g2d.drawImage(i2, -30, -20, null);
        }
    }
}
