package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
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
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
