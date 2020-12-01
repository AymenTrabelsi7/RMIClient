package Client;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Serveur.ServeurIntf;

public class Client extends UnicastRemoteObject {


	private static final long serialVersionUID = 1L;
	ServeurIntf Serveur;
	CBClient callback;
	
	private String username;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
		callback = new CBClient() 
		{
			public void notifyMe(String msg, String user) {
				if(user.equals(username)) System.out.println(user + " : " + msg);
			}
			
		};
		
	}
	
	public String getUsername() {
		return username;
	}
	
	
	
	public void setUsername(String name) {
		this.username = name;
	}

	public ServeurIntf getServeur() {
		// TODO Auto-generated method stub
		return Serveur;
	}

	public CBClient getCallback() {
		return callback;
	}
	

	
}
