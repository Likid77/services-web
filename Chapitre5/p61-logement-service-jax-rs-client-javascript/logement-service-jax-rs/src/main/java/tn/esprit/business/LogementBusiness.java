package tn.esprit.business;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.entities.Logement;
import tn.esprit.entities.Logement.Type;;

public class LogementBusiness {

	private List<Logement> logements;

	public LogementBusiness() {
		logements = new ArrayList<Logement>();
		logements.add(new Logement
				(1, "27 Rue des Roses", "Cité Ghazela", "Ariana", Type.Studio, "Cuisine équipée", 300f));
		logements.add(new Logement
				(2, "201 Résidence El Omrane 4", "Riadh El Andalous", "Ariana", Type.Appartement, "Chauffage central, ascenseur, climatisation", 700f));
		logements.add(new Logement
				(3, "540 Résidence Les Tulipes", "L'Aouina", "Tunis", Type.Appartement, "S+2, chauffage central, ascenseur, climatisation", 500f));
		logements.add(new Logement
				(4, "78 Rue des Oranges", "Le Bardo", "Tunis", Type.EtageVilla, "Chauffage central, ascenseur, climatisation", 400f));
		logements.add(new Logement
				(5, "58 Rue des Roses", "Cité Ghazela", "Ariana", Type.EtageVilla, "Cuisine équipée", 450f));
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}

	public Logement getLogementsByReference(int reference) {

		for (Logement l : logements) {
			if (l.getReference() == reference)
				return l;
		}
		return null;
	}

	public List<Logement> getLogementsByDelegation(String delegation) {
		List<Logement> liste = new ArrayList<Logement>();
		for (Logement l : logements) {
			if (l.getDelegation().equals(delegation))
				liste.add(l);
		}
		return liste;
	}

	public List<Logement> getLogementsByGouvernorat(String gouvernorat) {
		List<Logement> liste = new ArrayList<Logement>();
		for (Logement l : logements) {
			if (l.getGouvernorat().equals(gouvernorat))
				liste.add(l);
		}
		return liste;
	}

	public List<Logement> getLogementsByType(Type type) {
		List<Logement> liste = new ArrayList<Logement>();
		for (Logement l : logements) {
			if (l.getType().equals(type))
				liste.add(l);
		}
		return liste;
	}

	public List<Logement> getLogementsByPrix(float prix) {
		List<Logement> liste = new ArrayList<Logement>();
		for (Logement l : logements) {
			if (l.getPrix() <= prix)
				liste.add(l);
		}
		return liste;
	}

}
