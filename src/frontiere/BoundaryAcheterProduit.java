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
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol�e " + nomAcheteur
					+ " mais il faut �tre un habitant de notre village pour commercer ici");

		} else {
			StringBuilder acheter = new StringBuilder("Quel produit voulez-vous acheter ? ");
			String produit = Clavier.entrerChaine(acheter.toString());
			String[] vendeurs = controlAcheterProduit.trouverVendeur(produit);
			if (vendeurs.length == 0) {
				System.out.println("D�sol�, personne ne vend ce produit au march�");
			} else {
				StringBuilder commercant = new StringBuilder("Chez quel commer�ant voulez-vous acheter des fleurs ?");

				int i;
				for (i = 0; i < vendeurs.length; i++) {
					commercant.append("\n" + (i + 1) + " - " + vendeurs[i]);
				}
				int choixCommercant = Clavier.entrerEntier(commercant.toString()) - 1;
				System.out.println(
						nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + vendeurs[choixCommercant]);
				StringBuilder quantite = new StringBuilder("Bonjour " + nomAcheteur);
				quantite.append("\n Combien de " + produit + " voulez-vous acheter ?");
				int choixQuantite = Clavier.entrerEntier(quantite.toString());
				String[] etal = controlAcheterProduit.libererEtal(vendeurs[choixCommercant]);
				int quantiteRestante = controlAcheterProduit.acheterProduit(vendeurs[choixCommercant], choixQuantite);
				if (quantiteRestante == 0) {
					System.out.println(nomAcheteur + " veut acheter " + choixQuantite + " " + produit
							+ ", malheureusement il n'y en a plus !");
				} else if (quantiteRestante < choixQuantite) {
					System.out.println(nomAcheteur + " veut acheter " + choixQuantite + " " + produit
							+ ", malheureusement " + vendeurs[choixCommercant] + " n'en a plus que " + quantiteRestante
							+ ". " + nomAcheteur + " achète tout le stock de " + vendeurs[choixCommercant]);
				} else {
					System.out.println(nomAcheteur + " achète " + choixQuantite + " " + produit + " à"
							+ vendeurs[choixCommercant] + ".");
				}

			}
		}
	}
}
