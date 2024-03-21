package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					
					break;

				case 2:
					System.out.println("Bienvenue villageois "+nomVisiteur);
					int choixForce=0;
					StringBuilder force = new StringBuilder();
					force.append("Quel est votre force?");
					choixForce=Clavier.entrerEntier(force.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, choixForce);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder emmenage=new StringBuilder();
		emmenage.append("Bienvenue druide "+nomVisiteur+" Quelle est votre force?");
		int choixforce=0;
		choixforce=Clavier.entrerEntier(emmenage.toString());
		int effetPotionMax=0;
		int effetPotionMin=0;
		StringBuilder entrerPotionMin=new StringBuilder("Quelle est la force de potion la plus faible que vous produisez ? ");
		effetPotionMin=Clavier.entrerEntier(entrerPotionMin.toString());
		StringBuilder entrerPotionMax=new StringBuilder("Quelle est la force de potion la plus forte que vous produisez ? ");
		effetPotionMax=Clavier.entrerEntier(entrerPotionMax.toString());
		while(effetPotionMin>effetPotionMax){
			System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			effetPotionMin=Clavier.entrerEntier(entrerPotionMin.toString());			
			effetPotionMax=Clavier.entrerEntier(entrerPotionMax.toString());
		
		}
		controlEmmenager.ajouterDruide(nomVisiteur, choixforce, effetPotionMin, effetPotionMax);
	}
}
