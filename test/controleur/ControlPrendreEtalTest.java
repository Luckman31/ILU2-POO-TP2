package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlEmmenager=new ControlEmmenager(village);
	}
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
		
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertNotNull(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10));
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite(" "));
	}
}