package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
    private Chef abraracourcix;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		abraracourcix=new Chef("Abraracourcix",10,village);
		village=new Village("le village des irréductibles",10,5);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);

		
	}
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlePrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlePrendreEtal,"Constructeur ne renvoie pas null");

	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		int numeroEtal=controlPrendreEtal.prendreEtal("Bonemine", "fleur", 3);
		assertNotNull(numeroEtal);

	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");
		controlEmmenager.ajouterGaulois("Bonemine", 5);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("Existe pas"));

	}

}
