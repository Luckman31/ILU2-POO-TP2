package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		abraracourcix=new Chef("Abraracourcix",10,village);
		village=new Village("le village des irréductibles",10,5);
		village.setChef(abraracourcix);
	}
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage= new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNbEtals());
	}

}
