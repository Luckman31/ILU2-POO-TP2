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
					System.out.println("Bienvenue villageois "+ nomVisiteur+"\n");
					StringBuilder force=new StringBuilder();
					force.append("Quelle est votre force");
					int choixForce=Clavier.entrerEntier(force.toString());
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
		System.out.println("Bienvenue druide "+nomVisiteur+"\n");
		StringBuilder force=new StringBuilder();
		force.append("Quelle est votre force");
		int forceDruide=Clavier.entrerEntier(force.toString());
		int effetPotionMax=0;
		int effetPotionMin=1;
		while(effetPotionMax<effetPotionMin) {
			StringBuilder questionMin=new StringBuilder();
			questionMin.append("Quelle est la force de potion la plus faible que vous produisez ? ");
			effetPotionMin=Clavier.entrerEntier(questionMin.toString());
			StringBuilder questionMax=new StringBuilder();
			questionMax.append("Quelle est la force de potion la plus forte que vous produisez ? ");
			effetPotionMax=Clavier.entrerEntier(questionMax.toString());
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum\n");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
