package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
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
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 5);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
		assertNotNull(village.trouverHabitant("Bonemine"));

	}

}
