import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {
  ArrayList<LibraryItem> items;
  private JLabel catalogNumber, numberOfCopies, title, medium;
  private JTextField cNumber, nOfCopies, t, m;
  private JButton salvar, verTudo;

  public static void main(String[] args) {
    Main main = new Main("Main");
    main.pack();
    main.setSize(210, 150);
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setVisible(true);
    // new Main();
  }

  public Main(String titulo) {
    super(titulo);
    setLayout(new FlowLayout());

    catalogNumber = new JLabel("Catalog Number");
    numberOfCopies = new JLabel("Number of Copies");
    title = new JLabel("Title");
    medium = new JLabel("Medium");

    cNumber = new JTextField(10);
    nOfCopies = new JTextField(10);
    t = new JTextField(10);
    m = new JTextField(10);

    salvar = new JButton("Salvar");
    verTudo = new JButton("Ver Tudo");

    items = new ArrayList<LibraryItem>();

    this.add(catalogNumber);
    this.add(cNumber);
    this.add(numberOfCopies);
    this.add(nOfCopies);
    this.add(title);
    this.add(t);
    this.add(medium);
    this.add(m);
    this.add(salvar);
    this.add(verTudo);

    Escutador handler = new Escutador();
    salvar.addActionListener(handler);
    verTudo.addActionListener(handler);
    // Film f = new Film(12345, 100000, "O gado de anime", "Netflix", "Sawano", "12/05/2022", "Aniplex");
    // itemInfo(f);
  }

  public void itemInfo(LibraryItem item) {
    System.out.println(item);
  }

  private class Escutador implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == salvar) {
        if (
          !cNumber.getText().isEmpty() &&
          !nOfCopies.getText().isEmpty() &&
          !t.getText().isEmpty() &&
          !m.getText().isEmpty()
        ) {
          Object response = JOptionPane.showInputDialog(
            null,
            "Choose the RecordedItem type",
            "Options",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Film", "Computer Program" },
            "Film"
          );
          if (response.equals("Film")) {
            JTextField directorField = new JTextField(10);
            JTextField dateField = new JTextField(10);
            JTextField distribuitorField = new JTextField(10);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Director:"));
            myPanel.add(directorField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Date of Release:"));
            myPanel.add(dateField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Distribuitor:"));
            myPanel.add(distribuitorField);

            int result = JOptionPane.showConfirmDialog(
              null,
              myPanel,
              "Insert the aditional information",
              JOptionPane.OK_CANCEL_OPTION
            );
            if (result == JOptionPane.OK_OPTION) {
              String director = directorField.getText();
              String date = dateField.getText();
              String distribuitor = distribuitorField.getText();
              Film f = new Film(
                Integer.parseInt(cNumber.getText()),
                Integer.parseInt(nOfCopies.getText()),
                t.getText(),
                m.getText(),
                director,
                date,
                distribuitor
              );
              items.add(f);
              cNumber.setText("");
              nOfCopies.setText("");
              t.setText("");
              m.setText("");
            }
          }
          if (response.equals("Computer Program")) {
            JTextField versionField = new JTextField(10);
            JTextField platformField = new JTextField(10);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Version:"));
            myPanel.add(versionField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Platform:"));
            myPanel.add(platformField);

            int result = JOptionPane.showConfirmDialog(
              null,
              myPanel,
              "Insert the aditional information",
              JOptionPane.OK_CANCEL_OPTION
            );
            if (result == JOptionPane.OK_OPTION) {
              String version = versionField.getText();
              String platform = platformField.getText();
              ComputerProgram cp = new ComputerProgram(
                Integer.parseInt(cNumber.getText()),
                Integer.parseInt(nOfCopies.getText()),
                t.getText(),
                m.getText(),
                Integer.parseInt(version),
                platform
              );
              items.add(cp);
              cNumber.setText("");
              nOfCopies.setText("");
              t.setText("");
              m.setText("");
            }
          }
        }
      }
      if (event.getSource() == verTudo) {
        // for(LibraryItem item : items){
        //     System.out.println(item);
        // }

        //create a panel to show all the items
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(items.size(), 1));
        for (LibraryItem item : items) {
          myPanel.add(new JLabel(item.toString()));
        }
        JOptionPane.showMessageDialog(
          null,
          myPanel,
          "All Items",
          JOptionPane.PLAIN_MESSAGE
        );
      }
    }
  }
}
