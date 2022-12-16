import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;

public class JogoPainel extends JPanel implements Runnable, KeyListener {
    private static final int LARGURA = 625;
    private static final int ALTURA = 445;
    private Thread animacao;
    private int tempoEspera = 10;
    private boolean jogando = false;
    int diametroBola = 30;
    private int x = 50, y = 150, velocidadeX = 1, velocidadeY = 1;
    private int x2 = 50, y2 = 150, velocidadeX2 = 2, velocidadeY2 = 2;

    public JogoPainel() {
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
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
            moveBola();
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
        g.setColor(Color.WHITE);
        g.drawOval(x, y, diametroBola, diametroBola);
        g.fillOval(x2, y2, diametroBola, diametroBola);
    }

    private void moveBola() {
        if (x2 >= LARGURA - diametroBola) {
            velocidadeX2 = velocidadeX2 * -1;
        }
        if (x2 <= 0) {
            velocidadeX2 = velocidadeX2 * -1;
        }
        if (y2 >= ALTURA - diametroBola) {
            velocidadeY2 = velocidadeY2 * -1;
        }
        if (y2 <= 0) {
            velocidadeY2 = velocidadeY2 * -1;
        }

        x2 = x2 + velocidadeX2;
        y2 = y2 + velocidadeY2;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                velocidadeY = -10;
                if(y <= 0){
                velocidadeY = 0;
                System.out.println("Pressionado up");
            }else{
                y += velocidadeY;
            }
                break;
            case KeyEvent.VK_DOWN:
            velocidadeY = 10;
            if(y >= ALTURA - diametroBola){
                velocidadeY = 0;
            }else{
                y += velocidadeY;
            }
            break;
            case KeyEvent.VK_LEFT:
            velocidadeX = 10;
                if(x >= 0){
                    x -= velocidadeX;
                }
                break;
            case KeyEvent.VK_RIGHT:
            velocidadeX = 10;
            if(x <= LARGURA - diametroBola){
                x += velocidadeX;
            }
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                velocidadeY = 0;
                System.out.println("Solto up");
                break;
            case KeyEvent.VK_DOWN:
            velocidadeY = 0;
                break;
            case KeyEvent.VK_LEFT:
            velocidadeX = 0;
                break;
            case KeyEvent.VK_RIGHT:
            velocidadeX = 0;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}