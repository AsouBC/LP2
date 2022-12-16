//import java.awt.BorderLayout;
//import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextField;
//import java.awt.GridLayout;
import java.awt.FlowLayout;

public class ColorSelect extends JFrame{
    private JComboBox<String> colorSelect;
    String[] colors = {"BLUE", "RED", "GREEN", "YELLOW", "PURPLE", "ORANGE", "BLACK", "WHITE"};
    private JPanel colorTypes;
    private JPanel buttons;
    private JCheckBox colorsType1, colorsType2;
    private JButton confirmar, cancelar;

    public ColorSelect(String Titulo){
        super(Titulo);
        setLayout(new FlowLayout());
        setResizable(false);

        colorSelect = new JComboBox<String>(colors);
        //colorSelect.setLayout(new FlowLayout());
        //colorSelect.setSize(100, 10);
        colorTypes = new JPanel();
        colorTypes.setLayout(new FlowLayout());
        buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        colorsType1 = new JCheckBox("Background");
        colorsType1.setLayout(new FlowLayout());
        colorsType2 = new JCheckBox("Foreground");
        colorsType2.setLayout(new FlowLayout());
        confirmar = new JButton("OK");
        cancelar = new JButton("Cancel");

        colorTypes.add(colorsType1);
        colorTypes.add(colorsType2);
        buttons.add(confirmar);
        buttons.add(cancelar);
        this.add(colorSelect);
        this.add(colorTypes);
        this.add(buttons);
    }

    public static void main(String[] args) {
        ColorSelect colorSelect = new ColorSelect("Calculadora");
		colorSelect.setSize(300,300);
		colorSelect.setVisible(true);
    }
}
