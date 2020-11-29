package Client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Serveur.ServeurIntf;

public class Client {
	
	ServeurIntf Serveur;
	Scanner sc;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
		sc = new Scanner(System.in);
		try {
			new Listener(Serveur).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws Exception {
		

        Client chatClient=new Client();  
        String user;
        
        System.out.println(chatClient.Serveur.messageBienvenue());
        System.out.println("Entrez un nom d'utilisateur : ");
        user = chatClient.sc.nextLine();
        
        while(true) {
        	System.out.println(">");
        	chatClient.Serveur.ecrireMessage(chatClient.sc.nextLine(),user);
        }
        
        
    }
}
