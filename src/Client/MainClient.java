package Client;

import java.util.Scanner;

import Serveur.ServeurIntf;

public class MainClient {

	public static void main(String args[])   throws Exception {
		
		Scanner sc = new Scanner(System.in);
        Client client=new Client();
        String user  = "";
        ServeurIntf serveur = client.getServeur();
        
        boolean usernameLibre = true;
        do {
            System.out.println("Entrez un nom d'utilisateur : ");
            user = sc.nextLine();
            usernameLibre = serveur.newUser(user, client.getCallback());
            if(!usernameLibre) System.out.println("Nom d'utilisateur déjà pris :(");
        }while(!usernameLibre);
        
        client.setUsername(user);

        
        while(true) {
        	System.out.println(">");
        	serveur.ecrireMessage(sc.nextLine(),client.getUsername());
        }
        
        
    }

}
