package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlEmmenager=new ControlEmmenager(village);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
	}
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois());
		
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);

		controlEmmenager.ajouterGaulois("Bonemine", 3);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertNotNull(controlAfficherVillage.donnerNbEtals());
	}

}
