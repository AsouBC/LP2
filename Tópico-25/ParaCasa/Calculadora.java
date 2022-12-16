//import java.awt.BorderLayout;
//import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Calculadora extends JFrame{
    private JTextField texto;
    private JPanel funcoes;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;

    public Calculadora(String Titulo){
        super(Titulo);
        setLayout(new FlowLayout());
        setResizable(false);

        funcoes = new JPanel();
        funcoes.setLayout(new GridLayout(4, 4, 5, 5));
        texto = new JTextField(10);
        button1 = new JButton("7");
        button2 = new JButton("8");
        button3 = new JButton("9");
        button4 = new JButton("/");
        button5 = new JButton("4");
        button6 = new JButton("5");
        button7 = new JButton("6");
        button8 = new JButton("*");
        button9 = new JButton("1");
        button10 = new JButton("2");
        button11 = new JButton("3");
        button12 = new JButton("-");
        button13 = new JButton("0");
        button14 = new JButton(".");
        button15 = new JButton("+");
        button16 = new JButton("=");

        funcoes.add(button1);
        funcoes.add(button2);
        funcoes.add(button3);
        funcoes.add(button4);
        funcoes.add(button5);
        funcoes.add(button6);
        funcoes.add(button7);
        funcoes.add(button8);
        funcoes.add(button9);
        funcoes.add(button10);
        funcoes.add(button11);
        funcoes.add(button12);
        funcoes.add(button13);
        funcoes.add(button14);
        funcoes.add(button15);
        funcoes.add(button16);
        this.add(texto);
        this.add(funcoes);

    }
    

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora("Calculadora");
		calculadora.setSize(300,300);
		calculadora.setVisible(true);
    }
    
}