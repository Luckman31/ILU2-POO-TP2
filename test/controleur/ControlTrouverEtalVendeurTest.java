package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlEmmenager=new ControlEmmenager(village);
		controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
	}
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur(""));
	}

}
