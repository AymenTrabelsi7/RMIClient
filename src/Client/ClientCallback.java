package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallback extends UnicastRemoteObject implements CBClient  {

	private static final long serialVersionUID = 1L;


	protected ClientCallback() throws RemoteException {
		super();
	}


	public void notifyMe(String msg, String user) throws RemoteException {
		System.out.println(user + " : " + msg);
	}


	public void messageNew(String user) throws RemoteException {
		System.out.println("\nL'utilisateur " + user + " a rejoint le chat !");
		
	}


	
	public void messageLeft(String user) throws RemoteException {
		System.out.println("\nL'utilisateur " + user + " a quitté le chat :(");
	}

}
