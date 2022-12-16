import controller.ClienteController;
import dao.Conexao;
import model.Cliente;
import view.JanelaPrincipal;

public class App {
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App(){
        Cliente model = new Cliente();
        JanelaPrincipal view = new JanelaPrincipal();
        Conexao con = new Conexao("estudantes.csv", model);
        ClienteController controller = new ClienteController(model, view, con);
    }
}
