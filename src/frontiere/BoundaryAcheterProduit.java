package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	private String quantiteRestanteAffichage(int quantiteRestante, String nomAcheteur, int choixQuantite,
			String produit, String[] vendeurs, int choixCommercant) {
		StringBuilder affichage = new StringBuilder();
		if (quantiteRestante == 0) {
			affichage.append(nomAcheteur + " veut acheter " + choixQuantite + " " + produit
					+ ", malheureusement il n'y en a plus !");
		} else if (quantiteRestante < choixQuantite) {
			affichage.append(nomAcheteur + " veut acheter " + choixQuantite + " " + produit + ", malheureusement "
					+ vendeurs[choixCommercant] + " n'en a plus que " + quantiteRestante + ". " + nomAcheteur
					+ " achète tout le stock de " + vendeurs[choixCommercant]);
		} else {
			affichage.append(nomAcheteur + " achète " + choixQuantite + " " + produit + " à"
					+ vendeurs[choixCommercant] + ".");
		}
		return affichage.toString();
	}

	private int choisirVendeur(String[] vendeurs, String produit) {
		StringBuilder commercant = new StringBuilder(
				"Chez quel commer�ant voulez-vous acheter des " + produit + " ?");

		int i;
		for (i = 0; i < vendeurs.length; i++) {
			commercant.append("\n" + (i + 1) + " - " + vendeurs[i]);
		}
		return Clavier.entrerEntier(commercant.toString()) - 1;
	}

	private int quantiteChoisi(String produit, String vendeur, String nomAcheteur) {
		System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + vendeur);
		StringBuilder quantite = new StringBuilder("Bonjour " + nomAcheteur);
		quantite.append("\n Combien de " + produit + " voulez-vous acheter ?");
		return Clavier.entrerEntier(quantite.toString());
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol�e " + nomAcheteur
					+ " mais il faut �tre un habitant de notre village pour commercer ici");
		} else {
			StringBuilder acheter = new StringBuilder("Quel produit voulez-vous acheter ? ");
			String produit = Clavier.entrerChaine(acheter.toString());
			String[] vendeurs = controlAcheterProduit.trouverVendeur(produit);
			if (vendeurs == null) {
				System.out.println("D�sol�, personne ne vend ce produit au march�");
			} else {
				int choixCommercant = choisirVendeur(vendeurs, produit);
				int choixQuantite = quantiteChoisi(produit, vendeurs[choixCommercant], nomAcheteur);
				int quantiteRestante = controlAcheterProduit.acheterProduit(vendeurs[choixCommercant], choixQuantite);
				System.out.println(quantiteRestanteAffichage(quantiteRestante, nomAcheteur, choixQuantite, produit,
						vendeurs, choixCommercant));
			}
		}
	}
}
