package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	public String[] trouverVendeur(String produit) {
		
		Gaulois[] gaulois=village.rechercherVendeursProduit(produit);
		String[] vendeur=new String[gaulois.length];
		for (int i = 0; i < gaulois.length; i++) {
			vendeur[i]=gaulois[i].getNom();
		}
		return vendeur;
	}
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		donneesEtal[0]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[0];;
		donneesEtal[1]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[1];
		donneesEtal[2]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[2];
		donneesEtal[3]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[3];
		donneesEtal[4]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[4];
		return donneesEtal;
	}
	public int modifierQuantite(int quantite, String nomVendeur) {
		Gaulois gaulois=village.trouverHabitant(nomVendeur);
		return village.rechercherEtal(gaulois).acheterProduit(quantite);
	}
	
}
