package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertFalse(controlLibererEtal.isVendeur(" "));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertNotNull(controlLibererEtal.libererEtal("Bonemine"));
		
	}

}
