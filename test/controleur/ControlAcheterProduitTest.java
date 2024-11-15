package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlEmmenager=new ControlEmmenager(village);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
	}	
	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		assertNotNull(controlAcheterProduit.verifierIdentite("Bonemine"));
	
	}

	@Test
	void testTrouverVendeur() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		controlEmmenager.ajouterGaulois("Panoramix", 3);
		controlPrendreEtal.prendreEtal("Panoramix", "fleurs", 10);
		assertNotNull(controlAcheterProduit.trouverVendeur("fleurs"));
		assertNull(controlAcheterProduit.trouverVendeur("tomates"));
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		controlEmmenager.ajouterGaulois("Panoramix", 3);
		controlPrendreEtal.prendreEtal("Panoramix", "fleurs", 10);
		assertEquals(controlAcheterProduit.acheterProduit("Panoramix", 7),7);
		assertEquals(controlAcheterProduit.acheterProduit("Panoramix", 10),3);
		assertEquals(controlAcheterProduit.acheterProduit("Panoramix", 10),0);
	}

}
