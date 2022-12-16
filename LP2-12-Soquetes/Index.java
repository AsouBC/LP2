import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Index extends JFrame implements ActionListener{

    private JLabel jlabel;
	protected JTextField jtext;
	private JButton jbutton;

    public Index(String titulo){
        //PublishedItem itens = new PublishedItem(500, 100, "Percy Jackson", "Rick Riordan");
        //itemInfo(itens);
        super(titulo);
        setLayout(new FlowLayout());

        jlabel = new JLabel("Teste");
        jtext = new JTextField("Teste");
        jbutton = new JButton("Salvar");

        add(jlabel);
        add(jtext);
        add(jbutton);

        jtext.addActionListener(this);
		jbutton.addActionListener(this);
    }

    @Override
	public void actionPerformed(ActionEvent event) {
		
	}

    public static void main(String[] args) {
        Index index = new Index("Testes");
        index.setSize(300,130);
		index.setVisible(true);

    }
}

    /*public void itemInfo(LibraryItem item) {
        System.out.println(item);
    }*/
