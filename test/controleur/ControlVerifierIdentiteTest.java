package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irr�ductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite=new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite=new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertFalse(controlVerifierIdentite.verifierIdentite(" "));
		assertNotNull(controlVerifierIdentite.verifierIdentite(" "));
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
	}

}
