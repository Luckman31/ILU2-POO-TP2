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
		String[] vendeur=null;
		Gaulois[] gaulois=village.rechercherVendeursProduit(produit);
		if(gaulois!=null) {
			vendeur=new String[gaulois.length];
			for (int i = 0; i < gaulois.length; i++) {
				vendeur[i]=gaulois[i].getNom();
			}
		}
		return vendeur;
	}
	

	public int acheterProduit( String nomVendeur,int quantite) {
		int restant=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite();
		if(restant<quantite) {
			return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(restant);
		}else {
			
		
			return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
		}
	}
	
}
