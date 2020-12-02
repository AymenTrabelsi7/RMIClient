package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import Serveur.ServeurIntf;

public class Client{


	ServeurIntf Serveur;
	CBClient callback;
	
	private String username;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
		callback = new ClientCallback();
	}
	
	public String getUsername() {
		return username;
	}
	
	
	
	public void setUsername(String name) {
		this.username = name;
	}

	public ServeurIntf getServeur() {
		return Serveur;
	}

	public CBClient getCallback() {
		return callback;
	}
	

	
}
