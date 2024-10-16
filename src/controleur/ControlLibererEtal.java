package controleur;

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
		donneesEtal[0]=String.valueOf(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).isEtalOccupe());
		donneesEtal[1]=nomVendeur;
		donneesEtal[2]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getProduit();
		donneesEtal[3]=String.valueOf(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite());
		donneesEtal[4]=donneesEtal[3];
		return donneesEtal;
	}

}
