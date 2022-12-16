import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public class JogoPainel4 extends JPanel implements Runnable{
    private Thread animacao;
    private int tempoEspera = 10;
    private boolean jogando = false;
    ArrayList<Movel> bolas = new ArrayList<Movel>();

    Movel bola1 = new Movel(100, 100, 50, -10, 2, Color.BLUE);
    Movel bola2 = new Movel(200, 200, 51, -9, 3, Color.RED);
    Movel bola3 = new Movel(300, 150, 52, -8, 4, Color.GREEN);
    Movel bola4 = new Movel(400, 250, 53, -7, 5, Color.BLUE);
    Movel bola5 = new Movel(250, 125, 54, -6, 2, Color.YELLOW);
    Movel bola6 = new Movel(350, 200, 55, -5, 3, Color.WHITE);
    Movel bola7 = new Movel(450, 300, 56, -10, 4, Color.GREEN);
    Movel bola8 = new Movel(225, 150, 57, +9, 5, Color.GRAY);
    Movel bola9 = new Movel(325, 300, 58, -8, 2, Color.CYAN);
    Movel bola10 = new Movel(425, 400, 60, -7, 10, Color.YELLOW);

    

    public JogoPainel4() {
        setBackground(Color.BLACK);
        setFocusable(true);
        bolas.add(bola1);
        bolas.add(bola2);
        bolas.add(bola3);
        bolas.add(bola4);
        bolas.add(bola5);
        bolas.add(bola6);
        bolas.add(bola7);
        bolas.add(bola8);
        bolas.add(bola9);
        bolas.add(bola10);
    }

    public void addNotify() {
        super.addNotify();
        iniciarJogo();
    }

    private void iniciarJogo() {
        if (animacao == null || !jogando) {
            animacao = new Thread(this);
            animacao.start();
        }
    }

    public void run() {
        jogando = true;
        while (jogando) {
            for(Movel bola : bolas){
                bola.move();
            }

            repaint();
            try {
                Thread.sleep(tempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Movel bola : bolas){
            bola.paintComponent(g);
        }
    }

class Movel{
    private static final int LARGURA = 625;
    private static final int ALTURA = 445;

    private int diametroBola = 30;
    private int x = 50, y = 150, velocidadeX = 1, velocidadeY = 1;
    private Color cor;

    public Movel(int x, int y, int diametroBola, int velocidadeX, int velocidadeY, Color cor){
        this.x = x;
        this.y = y;
        this.diametroBola = diametroBola;
        this.velocidadeX = velocidadeX;
        this.velocidadeY = velocidadeY;
        this.cor = cor;
    }
    
    public void move() {
        if (x >= LARGURA - diametroBola) {
            velocidadeX = velocidadeX * -1;
        }
        if (x <= 0) {
            velocidadeX = velocidadeX * -1;
        }
        if (y >= ALTURA - diametroBola) {
            velocidadeY = velocidadeY * -1;
        }
        if (y <= 0) {
            velocidadeY = velocidadeY * -1;
        }
        x = x + velocidadeX;
        y = y + velocidadeY;
    }

    public void paintComponent(Graphics g) {
        g.setColor(cor);
        g.drawOval(x, y, diametroBola, diametroBola);
    }
}
}