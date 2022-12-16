package RABISCO;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JComponent;

public class ComponenteParaRabiscos extends JComponent implements MouseListener, MouseMotionListener, KeyListener{
    private ArrayList<Point> pontos;
    private int size = 8; private int halfsize = size/2;
    private Color cor;

    public ComponenteParaRabiscos(Color cor){
        this.cor = cor;
        pontos = new ArrayList<Point>(1024);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(cor);
        for(Point p:pontos){
            g2d.fillOval(p.x-halfsize, p.y-halfsize, size, size);
        }
    }

    public void mousePressed(MouseEvent e){
        pontos.add(e.getPoint());
        repaint();
    }

    public void mouseEntered(MouseEvent e){
        requestFocus();
    }

    public void mouseReleased(MouseEvent e){    
    }

    public void mouseClicked(MouseEvent e){    
    }

    public void mouseExited(MouseEvent e){    
    }

    public void mouseMoved(MouseEvent e){    
    }

    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_C){
            pontos.clear();
            repaint();
        }
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }

    public void mouseDragged(MouseEvent e){
    }
}