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
		if(!controlAcheterProduit.appartientVillage(nomAcheteur)) {
			System.out.println("Je suis d�sol�e "+nomAcheteur+" mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		else {
			
		
			StringBuilder questionNomProduit=new StringBuilder("Quel produit voulez-vous acheter ?");
			String nomProduit=null;
			nomProduit=Clavier.entrerChaine(questionNomProduit.toString());
			if(controlAcheterProduit.produitSurMarche(nomProduit)==null) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}
			else {
				StringBuilder animation=new StringBuilder("Chez quel commer�ant voules-vous acheter des "+nomProduit+" ?\n");
				int personne=0;
				for(int i=1;i<=controlAcheterProduit.produitSurMarche(nomProduit).length;i++) {
					animation.append(i+1+"- "+controlAcheterProduit.produitSurMarche(nomProduit)[i].getNom()+"\n");
				}
				personne=Clavier.entrerEntier(animation.toString());
				
				String nomVendeur=controlAcheterProduit.produitSurMarche(nomProduit)[personne].toString();
				StringBuilder questionQteProduit=new StringBuilder(nomAcheteur+"se d�place jusqu'� l'�tal du vendeur "+nomVendeur+"\nBonjour "+nomAcheteur+"\nCombien de "+nomProduit+" voulez-vous acheter ?");
				int qteProduit=0;
				qteProduit=Clavier.entrerEntier(questionQteProduit.toString());
				int qteDispo=controlAcheterProduit.quantiteDispo(nomVendeur);
				if(qteDispo==0) {
					System.out.println(nomAcheteur+" veut acheter "+qteProduit+" "+nomProduit+", malheureusement il n'y en a plus");
				}
				else if(qteProduit>qteDispo) {
					System.out.println(nomAcheteur+" veut acheter "+qteProduit+" "+nomProduit+", malheureusement. "+nomVendeur+" n'en a plus que "+qteDispo+". "+nomAcheteur+" ach�te tout le stock de Bonemine.");
					qteDispo=0;
				}
				else {
					System.out.println(nomAcheteur+" ach�te "+qteProduit+" "+nomProduit+"� "+nomVendeur+".");
				}
				
			}
		}
	}
}

