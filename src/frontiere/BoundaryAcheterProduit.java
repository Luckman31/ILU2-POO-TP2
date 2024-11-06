package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici");
			
		}else {
			StringBuilder acheter=new StringBuilder("Quel produit voulez-vous acheter ? ");
			String produit=Clavier.entrerChaine(acheter.toString());
			String[] vendeurs=controlAcheterProduit.trouverVendeur(produit);
			if(vendeurs.length==0) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			}else {
				StringBuilder commercant=new StringBuilder("Chez quel commerçant voulez-vous acheter des fleurs ?");
				
				int i;
				for (i=0; i < vendeurs.length; i++) {
					commercant.append("\n"+(i+1)+ " - " +vendeurs[i]);
				}
				int choixCommercant=Clavier.entrerEntier(commercant.toString())-1;
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeurs[choixCommercant]);
				StringBuilder quantite=new StringBuilder("Bonjour "+vendeurs[choixCommercant]);
				quantite.append("\n Combien de "+produit+" voulez-vous acheter ?");
				int choixQuantite=Clavier.entrerEntier(quantite.toString());
				
			}
		}
	}
}
