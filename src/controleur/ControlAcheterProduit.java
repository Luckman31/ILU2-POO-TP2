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
	
}
