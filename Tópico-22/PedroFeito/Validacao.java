import javax.swing.JOptionPane;

public class Validacao {

    String email, senha, matricula;
    boolean logado = false;
    String atributos[];

    public Validacao(){

        Leitura leitura = new Leitura();
        do{
            matricula = JOptionPane.showInputDialog("Digite sua matrícula");
            email = JOptionPane.showInputDialog("Digite seu e-mail");
            senha = JOptionPane.showInputDialog("Digite sua senha");
            if(leitura.Ler("tabela.csv", matricula, email, senha)){
                logado = true;
                this.atributos = leitura.getAtributos();
            }else{
                JOptionPane.showMessageDialog(null, "Matrícula ou senha inválida");
            }
        }while(logado == false);
       
    }

    protected boolean getLogado(){
        return logado;
    }

    public String[] getAtributos(){
        return atributos;
    }
}