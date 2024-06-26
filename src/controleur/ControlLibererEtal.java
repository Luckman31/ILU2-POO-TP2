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
	 * 		[0] : un boolean indiquant si l'�tal est occup�
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantit� de produit � vendre au d�but du march�
	 * 		[4] : quantit� de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		String[] donneesEtal = new String[5];
		if(etal!=null) {
			boolean etalOccupe=etal.isEtalOccupe();
			String nomVendeurEtal=etal.getVendeur().getNom();
			String produitVendu=etal.getProduit();
			int quantiteInitial=etal.getQuantiteDebut();
			int quantiteVendue=etal.getQuantiteDebut()-etal.getQuantite();
			donneesEtal[0]=String.valueOf(etalOccupe);
			donneesEtal[1]=nomVendeurEtal;
			donneesEtal[2]=produitVendu;
			donneesEtal[3]=String.valueOf(quantiteInitial);
			donneesEtal[4]=String.valueOf(quantiteVendue);
		}
		
		return donneesEtal;
	}

}
