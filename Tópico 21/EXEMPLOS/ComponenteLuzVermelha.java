package EXEMPLOS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComponenteLuzVermelha extends JComponent implements ActionListener{
    private int nivel, passo;
    private Timer timer;

    public ComponenteLuzVermelha(int passo){
        this.passo = passo;
        nivel = 0;
        setPreferredSize(new Dimension(200, 200));
        timer = new Timer(50, this);
        timer.setCoalesce(true);
        timer.start();
    }

    protected void paintComponet(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        //Calculamos a cor de acordo com o passo.
        g.setColor(new Color(nivel/100, 0, 0));
        g.fillArc(0, 0, getWidth(), getHeight(), 0, 360);
    }

    public void actionPerformed(ActionEvent e){
        if(nivel < 25500) nivel += passo;
        repaint();
    }
}
