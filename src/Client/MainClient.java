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
        System.out.print("Bienvenue dans le chat, " + user + " ! Il y a actuellement " + serveur.userNumber() + " personne");
        if(serveur.userNumber() > 1) System.out.print("s ");
        System.out.println("dans le chat.\nPour quitter, entrez /quit.");
        
        while(true) {
        	System.out.print(">");
        	String scan = sc.nextLine();
        	if(!scan.equals("/quit")) serveur.ecrireMessage(scan,client.getUsername());
        	else break;
        }
        System.out.println("Vous avez quitté le chat.");
        sc.close();
        client.getServeur().userLeft(client.getUsername());
    }

}
