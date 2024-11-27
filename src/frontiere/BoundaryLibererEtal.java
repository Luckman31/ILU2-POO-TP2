package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
		} else {
			String[] etal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(etal[0]);
			if (etalOccupe) {
				System.out.println("Vous avez vendu " + etal[4] + " sur " + etal[3] + " " + etal[2] + ".");
				System.out.println("En revoir " + etal[1] + ", passez une bonne journ�e");
			}
		}
	}

}
