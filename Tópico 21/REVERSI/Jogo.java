package REVERSI;

import javax.swing.JFrame;

public class Jogo extends JFrame{
    public Jogo(){
        super("REVERSI");
        getContentPane().add(new Tabuleiro());
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Jogo();
    }
}
