package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean vendeurExiste=controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!vendeurExiste) {
			System.out.println("Je suis d�sol�e "+nomVendeur+" mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un �tal.");
			boolean etalDisponible=controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("D�sol�e "+nomVendeur+" je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
				
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous !\nIl me faudrait quelques renseignements.");
		StringBuilder questionNomProduit=new StringBuilder("Quel produit souhaitez-vous vendre ?");
		String nomProduit=null;
		nomProduit=Clavier.entrerChaine(questionNomProduit.toString());
		StringBuilder questionQteProduit=new StringBuilder("Combien souhaitez-vous en vendre ?");
		int qteProduit=0;
		qteProduit=Clavier.entrerEntier(questionQteProduit.toString());
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, nomProduit, qteProduit);
		if(numeroEtal!=-1) {
			
			System.out.println("Le vendeur "+nomVendeur+" s'est intall� � l'�tal n�"+(numeroEtal+1));
		}
		
	}
}
