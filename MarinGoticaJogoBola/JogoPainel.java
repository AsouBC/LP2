import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class JogoPainel extends JPanel implements Runnable{
    private Thread animacao;
    private int tempoEspera = 10;
    private boolean jogando = false;
    ArrayList<Movel> bolas = new ArrayList<Movel>();

    public JogoPainel(int qtdBolas) {
        setBackground(Color.BLACK);
        setFocusable(true);
        OpenTXTFile txt = new OpenTXTFile();
        bolas = txt.LerTXT("bolas.txt");
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
        g.setColor(Color.WHITE);
        for(Movel bola : bolas){
            bola.paintComponent(g);
        }
    }
}

class Movel{
    private static final int LARGURA = 625, ALTURA = 445;
    private int diametroBola = 30;
    private int x = 50, y = 150;
    private int velocidadeX = 1, velocidadeY = 1;
    private Color color;

    public void move() {
        x += velocidadeX;
        y += velocidadeY;
        if (x >= LARGURA - diametroBola) {
            velocidadeX *= -1;
        }
        if (x <= 0) {
            velocidadeX *= -1;
        }
        if (y >= ALTURA - diametroBola) {
            velocidadeY *= -1;
        }
        if (y <= 0) {
            velocidadeY *= -1;
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diametroBola, diametroBola);
    }

    public Movel(int x, int y, int diametroBola) {
        this.x = x;
        this.y = y;
        this.diametroBola = diametroBola;
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        this.color = new Color(r, g, b);
    }
}

class OpenTXTFile {

    public ArrayList<Movel> LerTXT(String file) {
      Scanner scanner;
      File txt = new File(file);
      ArrayList<Movel> vetorDeBolas = new ArrayList<>();
  
      try {
        scanner = new Scanner(txt);
        scanner.nextLine();
  
        while (scanner.hasNextLine()) {
          String[] line = scanner.nextLine().split(";");
          //pass values of line to integer
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int diametroBola = Integer.parseInt(line[2]);
          
          Movel bola = new Movel(x, y, diametroBola);
          vetorDeBolas.add(bola);
        }
        scanner.close();
      } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
      }
      return vetorDeBolas;
    }
  }