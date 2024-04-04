package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null;
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
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		String[] donneesEtal = new String[5];
		if(etal!=null) {
			boolean etalOccupe=etal.isEtalOccupe();
			String nomVendeurEtal=etal.getVendeur().getNom();
			String produitVendu=etal.getProduit();
			int quantiteInitial=etal.getQuantite();
			int quantiteVendue=quantiteInitial-etal.getQuantite();
			donneesEtal[0]=String.valueOf(etalOccupe);
			donneesEtal[1]=nomVendeurEtal;
			donneesEtal[2]=produitVendu;
			donneesEtal[3]=String.valueOf(quantiteInitial);
			donneesEtal[4]=String.valueOf(quantiteVendue);
		}
		
		return donneesEtal;
	}

}
