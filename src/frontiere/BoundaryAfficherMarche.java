package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche=controlAfficherMarche.donnerInfosMarche();
		StringBuilder infos=new StringBuilder();
		if(infosMarche.length==0) {
			infos.append("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur+", vous trouverez au marché:");
			for(int i=0;i<infosMarche.length;i++) {
				if(i==0) {
					infos.append("- "+infosMarche[i]);
					
				}
				if(i==1) {
					infos.append(" qui vend "+infosMarche[i]);
				}
				if(i==2) {
					infos.append(" "+infosMarche[i]);
				}
				
			}
		}
		System.out.println(infos);
	}
}
