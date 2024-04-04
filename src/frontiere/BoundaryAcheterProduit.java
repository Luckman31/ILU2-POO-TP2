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
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			
		
			StringBuilder questionNomProduit=new StringBuilder("Quel produit voulez-vous acheter ?");
			String nomProduit=null;
			nomProduit=Clavier.entrerChaine(questionNomProduit.toString());
			if(controlAcheterProduit.produitSurMarche(nomProduit)==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				StringBuilder animation=new StringBuilder("Chez quel commerçant voules-vous acheter des fleurs ?");
				int personne=0;
				for(int i=0;i<controlAcheterProduit.produitSurMarche(nomProduit).length;i++) {
					animation.append(i+"- "+controlAcheterProduit.produitSurMarche(nomProduit)[i]);
				}
				personne=Clavier.entrerEntier(animation.toString());
				
				if(personne>controlAcheterProduit.produitSurMarche(nomProduit).length) {
					
				}
				StringBuilder questionQteProduit=new StringBuilder(nomAcheteur+"se déplace jusqu'à l'étal du vendeur "+controlAcheterProduit.produitSurMarche(nomProduit)[personne]+"\nBonjour "+nomAcheteur+"\nCombien de "+nomProduit+" voulez-vous acheter ?");
				int qteProduit=0;
				qteProduit=Clavier.entrerEntier(questionQteProduit.toString());
				
			}
		}
	}
}

