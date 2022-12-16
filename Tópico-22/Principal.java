import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener{
    private JPanel jpanel;
    private JPanel jpanelButtons;

    private JCheckBox administrativo;
    private JCheckBox aluno;
    private JCheckBox professor;

    private JLabel cargo;
    private JLabel matrícula;
    private JLabel nome;
    private JLabel email;
    private JLabel senha;
    private JLabel turma;
    private JLabel setor;

    private JTextField textFieldCargo;
    private JTextField textFieldMatrícula;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JTextField textFieldSenha;
    private JTextField textFieldTurma;
    private JTextField textFieldSetor;

    private JButton botaoAlterar;
    private JButton botaoAtualizar;

    public Principal(){
        Validar validar = new Validar();
        if(validar.getLogado()){
            Principal janela = new Principal("Cadastro", validar.getValores());
            janela.setVisible(true);
        }
    }

    public Principal(String titulo, String[] valores){
        super(titulo);
        setLayout(new FlowLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cargo = new JLabel("Cargo");
        matrícula = new JLabel("Matrícula");
        nome = new JLabel("Nome");
        email = new JLabel("Email");
        senha = new JLabel("Senha");
        turma = new JLabel("Turma");
        setor = new JLabel("Setor");

        textFieldCargo = new JTextField(valores[0], 10);
        textFieldMatrícula = new JTextField(valores[1], 10);
        textFieldNome = new JTextField(valores[2], 10);
        textFieldEmail = new JTextField(valores[3], 10);
        textFieldSenha = new JTextField(valores[4], 10);

        botaoAlterar = new JButton("Alterar");
        botaoAtualizar = new JButton("Atualizar");

        botaoAtualizar.setEnabled(false);

        jpanel = new JPanel(new GridLayout(7, 2, 5, 5));
        jpanelButtons = new JPanel(new FlowLayout());

        administrativo = new JCheckBox("Administrativo");
        aluno = new JCheckBox("Aluno");
        professor = new JCheckBox("Professor");

        administrativo.setEnabled(false);
        aluno.setEnabled(false);
        professor.setEnabled(false);

        if(valores[0].toLowerCase().equals("administrativo")){
            administrativo.setSelected(true);
            textFieldTurma = new JTextField(valores[5], 10);
            textFieldSetor = new JTextField(valores[6], 10);
        }else if (valores[0].toLowerCase().equals("aluno")){
            aluno.setSelected(true);
            textFieldTurma = new JTextField(valores[5], 10);
            textFieldSetor = new JTextField("", 10);
        }else if (valores[0].toLowerCase().equals("professor")){
            professor.setSelected(true);
            textFieldTurma = new JTextField("", 10);
            textFieldSetor = new JTextField("", 10);
        }

        textFieldCargo.setEnabled(false);
        textFieldMatrícula.setEnabled(false);
        textFieldNome.setEnabled(false);
        textFieldEmail.setEnabled(false);
        textFieldSenha.setEnabled(false);
        textFieldTurma.setEnabled(false);
        textFieldSetor.setEnabled(false);

        jpanel.add(cargo);
        jpanel.add(textFieldCargo);
        jpanel.add(matrícula);
        jpanel.add(textFieldMatrícula);
        jpanel.add(nome);
        jpanel.add(textFieldNome);
        jpanel.add(email);
        jpanel.add(textFieldEmail);
        jpanel.add(senha);
        jpanel.add(textFieldSenha);
        jpanel.add(turma);
        jpanel.add(textFieldTurma);
        jpanel.add(setor);
        jpanel.add(textFieldSetor);

        jpanelButtons.add(botaoAlterar);
        jpanelButtons.add(botaoAtualizar);

        this.add(administrativo);
        this.add(aluno);
        this.add(professor);
        this.add(jpanel);
        this.add(jpanelButtons);

        botaoAlterar.addActionListener(this);
        botaoAtualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        AtualizarCSV atualizarCSV = new AtualizarCSV();

        if(e.getSource() == botaoAlterar && administrativo.isSelected()){
            textFieldCargo.setEnabled(true);
            textFieldMatrícula.setEnabled(true);
            textFieldNome.setEnabled(true);
            textFieldEmail.setEnabled(true);
            textFieldSenha.setEnabled(true);
            textFieldSetor.setEnabled(true);
            botaoAtualizar.setEnabled(true);
        }else if(e.getSource() == botaoAlterar && aluno.isSelected()){
            textFieldCargo.setEnabled(true);
            textFieldMatrícula.setEnabled(true);
            textFieldNome.setEnabled(true);
            textFieldEmail.setEnabled(true);
            textFieldSenha.setEnabled(true);
            textFieldTurma.setEnabled(true);
            botaoAtualizar.setEnabled(true);
        }else if(e.getSource() == botaoAlterar && professor.isSelected()){
            textFieldCargo.setEnabled(true);
            textFieldMatrícula.setEnabled(true);
            textFieldNome.setEnabled(true);
            textFieldEmail.setEnabled(true);
            textFieldSenha.setEnabled(true);
            botaoAtualizar.setEnabled(true);
        }

        if (administrativo.isSelected()) {
            if(e.getSource() == botaoAtualizar && !(textFieldCargo.getText().toLowerCase().equals("administrativo"))){
                if(textFieldCargo.getText().toLowerCase().equals("professor")){
                    textFieldTurma.setText("");
                    textFieldSetor.setText("");
                }else if(textFieldCargo.getText().toLowerCase().equals("aluno")){
                    textFieldSetor.setText("");
                    JOptionPane.showMessageDialog(null, "Insira a turma do aluno");
                    textFieldTurma.setEnabled(true);
                }
            }
            if (e.getSource() == botaoAtualizar && !(textFieldCargo.getText().toLowerCase().equals("professor"))
                    && !(textFieldCargo.getText().toLowerCase().equals("aluno"))
                    && !(textFieldCargo.getText().toLowerCase().equals("administrativo"))) {
                JOptionPane.showMessageDialog(null, "Selecione um cargo válido");
                textFieldCargo.setText("");
            } else if (e.getSource() == botaoAtualizar && !(textFieldSetor.getText().toLowerCase().equals("secretaria"))
                    && !(textFieldSetor.getText().toLowerCase().equals("biblioteca"))
                    && !(textFieldSetor.getText().toLowerCase().equals("estágio")) && (textFieldCargo.getText().toLowerCase().equals("administrativo"))) {
                JOptionPane.showMessageDialog(null, "Selecione um setor válido");
                textFieldSetor.setText("");
            } else {
                if (e.getSource() == botaoAtualizar) {
                    String dados = textFieldCargo.getText() + ";" + textFieldMatrícula.getText() + ";"
                            + textFieldNome.getText() + ";" + textFieldEmail.getText() + ";" + textFieldSenha.getText()
                            + ";" + textFieldTurma.getText() + ";" + textFieldSetor.getText();
                    if (atualizarCSV.Escrever("tabela.csv", dados, textFieldEmail.getText(), textFieldSenha.getText())){
                        JOptionPane.showMessageDialog(null,
                                "Alteração realizada com sucesso, o arquivo csv foi alterado com as modificações");
                        textFieldCargo.setEnabled(false);
                        textFieldMatrícula.setEnabled(false);
                        textFieldNome.setEnabled(false);
                        textFieldEmail.setEnabled(false);
                        textFieldSenha.setEnabled(false);
                        textFieldTurma.setEnabled(false);
                        textFieldSetor.setEnabled(false);
                    }
                }
            }
        } else if (aluno.isSelected() || textFieldCargo.getText().toLowerCase().equals("aluno")) {
            if(e.getSource() == botaoAtualizar && !(textFieldCargo.getText().toLowerCase().equals("aluno"))){
                if(textFieldCargo.getText().toLowerCase().equals("professor")){
                    textFieldTurma.setText("");
                }else if(textFieldCargo.getText().toLowerCase().equals("administrativo")){
                    textFieldTurma.setText("");
                    JOptionPane.showMessageDialog(null, "Insira o setor do administrativo");
                    textFieldSetor.setEnabled(true);
                }
            }
            if (e.getSource() == botaoAtualizar && !(textFieldCargo.getText().toLowerCase().equals("professor"))
                    && !(textFieldCargo.getText().toLowerCase().equals("aluno"))
                    && !(textFieldCargo.getText().toLowerCase().equals("administrativo"))) {
                JOptionPane.showMessageDialog(null, "Selecione um cargo válido");
                textFieldCargo.setText("");
            } else if (e.getSource() == botaoAtualizar && !(textFieldTurma.getText().toLowerCase().equals("inf1"))
                    && !(textFieldTurma.getText().toLowerCase().equals("inf2"))
                    && !(textFieldTurma.getText().toLowerCase().equals("inf3"))
                    && !(textFieldTurma.getText().toLowerCase().equals("camb1"))
                    && !(textFieldTurma.getText().toLowerCase().equals("camb2"))
                    && !(textFieldTurma.getText().toLowerCase().equals("camb3"))
                    && !(textFieldTurma.getText().toLowerCase().equals("ele1"))
                    && !(textFieldTurma.getText().toLowerCase().equals("ele2"))
                    && !(textFieldTurma.getText().toLowerCase().equals("ele3")) && (textFieldCargo.getText().toLowerCase().equals("aluno"))) {
                JOptionPane.showMessageDialog(null, "Selecione uma turma válida");
                textFieldTurma.setText("");
                textFieldTurma.setEnabled(true);
            } else {
                if (e.getSource() == botaoAtualizar) {
                    String dados = textFieldCargo.getText() + ";" + textFieldMatrícula.getText() + ";"
                            + textFieldNome.getText() + ";" + textFieldEmail.getText() + ";" + textFieldSenha.getText()
                            + ";" + textFieldTurma.getText() + ";" + textFieldSetor.getText();
                    if (atualizarCSV.Escrever("tabela.csv", dados, textFieldEmail.getText(), textFieldSenha.getText())) {
                        JOptionPane.showMessageDialog(null,
                                "Alteração realizada com sucesso, o arquivo csv foi alterado com as modificações");
                        textFieldCargo.setEnabled(false);
                        textFieldMatrícula.setEnabled(false);
                        textFieldNome.setEnabled(false);
                        textFieldEmail.setEnabled(false);
                        textFieldSenha.setEnabled(false);
                        textFieldTurma.setEnabled(false);
                        textFieldSetor.setEnabled(false);
                    }
                }
            }
        } else if (professor.isSelected() || textFieldCargo.getText().toLowerCase().equals("professor")) {
            if(e.getSource() == botaoAtualizar && !(textFieldCargo.getText().toLowerCase().equals("professor"))){
                if(textFieldCargo.getText().toLowerCase().equals("aluno")){
                    JOptionPane.showMessageDialog(null, "Insira a turma do aluno");
                    textFieldTurma.setEnabled(true);
                }else if(textFieldCargo.getText().toLowerCase().equals("administrativo")){
                    JOptionPane.showMessageDialog(null, "Insira o setor do administrativo");
                    textFieldSetor.setEnabled(true);
                }
            }
            if (e.getSource() == botaoAtualizar && !(textFieldCargo.getText().toLowerCase().equals("professor"))
                    && !(textFieldCargo.getText().toLowerCase().equals("aluno"))
                    && !(textFieldCargo.getText().toLowerCase().equals("administrativo")) && (textFieldCargo.getText().toLowerCase().equals("administrativo"))) {
                JOptionPane.showMessageDialog(null, "Selecione um cargo válido");
                textFieldCargo.setText("");
            } else {
                if (e.getSource() == botaoAtualizar) {
                    String dados = textFieldCargo.getText() + ";" + textFieldMatrícula.getText() + ";"
                            + textFieldNome.getText() + ";" + textFieldEmail.getText() + ";" + textFieldSenha.getText()
                            + ";" + textFieldTurma.getText() + ";" + textFieldSetor.getText();
                    if (atualizarCSV.Escrever("tabela.csv", dados, textFieldEmail.getText(), textFieldSenha.getText())) {
                        JOptionPane.showMessageDialog(null,
                                "Alteração realizada com sucesso, o arquivo csv foi alterado com as modificações");
                        textFieldCargo.setEnabled(false);
                        textFieldMatrícula.setEnabled(false);
                        textFieldNome.setEnabled(false);
                        textFieldEmail.setEnabled(false);
                        textFieldSenha.setEnabled(false);
                        textFieldTurma.setEnabled(false);
                        textFieldSetor.setEnabled(false);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Principal();
    }
}