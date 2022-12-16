import javax.swing.JOptionPane;

public class Validar {
    String email, senha;
    boolean logado = false;
    String valores[];

    public Validar(){
        LerArquivo lerarquivo = new LerArquivo();
        do{
            email = JOptionPane.showInputDialog("Digite seu email");
            senha = JOptionPane.showInputDialog("Digite sua senha");
            if(lerarquivo.lerArq("tabela.csv", email, senha)){
                logado = true;
                this.valores = lerarquivo.getValores();
            }else{
                JOptionPane.showMessageDialog(null, "Email ou senha inválida!");
            }
        }while(logado == false);
    }

    public boolean getLogado(){
        return logado;
    }

    public String[] getValores(){
        return this.valores;
    }
}
