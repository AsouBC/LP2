import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Init extends JFrame{
    private CorpoAcademico membro;
    private ArrayList<CorpoAcademico> corpoAcademico;
    private JTextField cargo;
    private JTextField matricula;
    private JTextField nome;
    private JTextField email;
    private JTextField senha;
    private JTextField setor;
    private JTextField turma;
    private JButton atualizar;
    private ExportCSVFile export;
    private JFrame frame;

    public Init(){
        corpoAcademico = new ArrayList<>();
        ReadCSVFile read = new ReadCSVFile();
        corpoAcademico = read.readCSV("tabela.csv", corpoAcademico);
        export = new ExportCSVFile();
        frame = new JFrame();
        frame.setLayout(new FlowLayout());

        membro = login(corpoAcademico);
        cargo = new JTextField(membro.getCargo());
        matricula = new JTextField(membro.getMatricula() + "");
        nome = new JTextField(membro.getNome());
        email = new JTextField(membro.getEmail());
        senha = new JTextField(membro.getSenha());
        atualizar = new JButton("Atualizar Dados");

        frame.add(cargo);
        frame.add(matricula);
        frame.add(nome);
        frame.add(email);
        frame.add(senha);

        if(membro.getCargo().equals("Aluno")){
            turma = new JTextField(((Aluno) membro).getTurma());
            frame.add(turma);
        }else if(membro.getCargo().equals("Administrativo")){
            setor = new JTextField(((Administrativo) membro).getSetor());
            frame.add(setor);
        }
        frame.add(atualizar);

        ActionHandler handler = new ActionHandler();
        atualizar.addActionListener(handler);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Init(CorpoAcademico membro, ArrayList<CorpoAcademico> corpoAcademico){
        export = new ExportCSVFile();
        frame = new JFrame();
        frame.setLayout(new FlowLayout());

        cargo = new JTextField(membro.getCargo());
        matricula = new JTextField(membro.getMatricula() + "");
        nome = new JTextField(membro.getNome());
        email = new JTextField(membro.getEmail());
        senha = new JTextField(membro.getSenha());
        atualizar = new JButton("Atualizar Dados");

        frame.add(cargo);
        frame.add(matricula);
        frame.add(nome);
        frame.add(email);
        frame.add(senha);

        if(membro.getCargo().equals("Aluno")){
            turma = new JTextField(((Aluno) membro).getTurma());
            frame.add(turma);
        }else if(membro.getCargo().equals("Administrativo")){
            setor = new JTextField(((Administrativo) membro).getSetor());
            frame.add(setor);
        }
        frame.add(atualizar);

        ActionHandler handler = new ActionHandler();
        atualizar.addActionListener(handler);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ActionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CorpoAcademico membroAtualizado = membro;
            if(e.getSource() == atualizar){
                try{
                    if(membro.getCargo() == cargo.getText()){
                        membro.setMatricula(Integer.parseInt(matricula.getText()));
                        membro.setNome(nome.getText());
                        membro.setEmail(email.getText());
                        membro.setSenha(senha.getText());
                        if(membro.getCargo().equals("Aluno")){
                            ((Aluno) membro).setTurma(turma.getText());
                        }else if(membro.getCargo().equals("Administrativo")){
                            ((Administrativo) membro).setSetor(setor.getText());
                        }
                        export.exportCSV(corpoAcademico, "tabela.csv");
                        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                    }else{
                        if(cargo.getText().equals("Aluno")){
                            String DataTurma = JOptionPane.showInputDialog("Digite a turma do aluno");
                            membroAtualizado = new Aluno(cargo.getText(), Integer.parseInt(matricula.getText()), nome.getText(), email.getText(), senha.getText(), DataTurma);
                            corpoAcademico.remove(membro);
                            corpoAcademico.add(membroAtualizado);
                            export.exportCSV(corpoAcademico, "tabela.csv");
                            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                        }else if(cargo.getText().equals("Administrativo")){
                            String DataSetor = JOptionPane.showInputDialog("Digite o setor do administrativo");
                            membroAtualizado = new Administrativo(cargo.getText(), Integer.parseInt(matricula.getText()), nome.getText(), email.getText(), senha.getText(), DataSetor);
                            corpoAcademico.remove(membro);
                            corpoAcademico.add(membroAtualizado);
                            export.exportCSV(corpoAcademico, "tabela.csv");
                            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                        }
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + ex.getMessage());
                }
                frame.dispose();
                new Init(membroAtualizado, corpoAcademico);
            }
        }
    }

    public static void main(String[] args) {
        new Init();
    }

    public CorpoAcademico login(ArrayList<CorpoAcademico> corpoAcademico){
        String emailTmp, senhaTmp;
        CorpoAcademico membro;
        emailTmp = JOptionPane.showInputDialog("Insira o email:");
        senhaTmp = JOptionPane.showInputDialog("Insira a senha:");

        for(CorpoAcademico membroCorpo : corpoAcademico){
            if(membroCorpo.getEmail().equals(emailTmp) && membroCorpo.getSenha().equals(senhaTmp)){
                return membroCorpo;
            }
        }

        JOptionPane.showMessageDialog(null, "Informações inválidas!");
        membro = login(corpoAcademico);
        return membro;
    }
}

