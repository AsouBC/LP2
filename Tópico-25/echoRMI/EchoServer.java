package echoRMI;

import javax.swing.JOptionPane;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
//import java.util.Scanner;

public class EchoServer extends UnicastRemoteObject implements EchoInterface {

	public EchoServer() throws RemoteException {
	}

	@Override
	public String getEcho(String mensagem) throws RemoteException {
		/*String retorno = !mensagem.equals("") ? 
			"Voc� enviou:  " + mensagem : "Digite algo por favor!";
		System.out.println(retorno);
		*/
		//Scanner ler = new Scanner(System.in);
		String retorno = "" +JOptionPane.showInputDialog("Responda o usuário:");
		System.out.println(retorno);
		return retorno;
	}

	public static void main(String args[]) {
		EchoServer cal;
		try {
			cal = new EchoServer();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///EchoServer", cal);
			System.out.println("Ready !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
