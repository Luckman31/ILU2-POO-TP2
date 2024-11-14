package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		Etal vendeur=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(vendeur!=null) {
			donneesEtal[0]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[0];
			donneesEtal[1]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[1];
			donneesEtal[2]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[2];
			donneesEtal[3]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[3];
			donneesEtal[4]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal()[4];
		}else {
			donneesEtal=null;
		}
		return donneesEtal;
	}

}
