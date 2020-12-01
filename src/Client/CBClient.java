package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CBClient extends Remote {
	public void notifyMe(String msg,String user) throws RemoteException;
}
