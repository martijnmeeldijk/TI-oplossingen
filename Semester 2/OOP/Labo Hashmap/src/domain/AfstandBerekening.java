package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AfstandBerekening {
	private Map<TweeSteden, Double> afstanden;

	public AfstandBerekening(Map<TweeSteden, Double> afstanden) {
		this.afstanden = afstanden;
	}

	public double getAfstandTraject(String traject) {
		return getAfstandTraject(convertToTraject(traject));
	}

	public double getAfstandTraject(Collection<String> deeltraject) {
		double totaal = 0;
		String firstCity = null;
		for (String nextCity : deeltraject) {
			if (firstCity != null) {
				totaal += getAfstandTussen(firstCity, nextCity);
			}
			firstCity = nextCity;
		}
		return totaal;
	}

	private double getAfstandTussen(String firstCity, String nextCity) {
		TweeSteden steden = new TweeSteden(firstCity, nextCity);
		if (afstanden.containsKey(steden)) {
			return afstanden.get(steden);
		} else {
			throw new IllegalArgumentException("Geen gegevens gekend voor " + firstCity + " naar " + nextCity);
		}
	}

	private Collection<String> convertToTraject(String traject) {
		traject = traject.replaceAll(" ", "");
		traject = traject.replaceAll("\\[", "");
		traject = traject.replaceAll("\\]", "");
		String[] rij = traject.split(",");

		return Arrays.asList(rij);
	}

	public Map<TweeSteden, Double> getTrajectOnderdelen(String traject) {
		return getTrajectOnderdelen(convertToTraject(traject));
	}

	public Map<TweeSteden, Double> getTrajectOnderdelen(Collection<String> deeltraject)
			throws IllegalArgumentException {
		Map<TweeSteden, Double> trajectOnderdelen = new LinkedHashMap<TweeSteden, Double>();

		String firstCity = null;
		for (String nextCity : deeltraject) {
			if (firstCity != null) {
				trajectOnderdelen.put(new TweeSteden(firstCity, nextCity), getAfstandTussen(firstCity, nextCity));
			}
			firstCity = nextCity;
		}

		return trajectOnderdelen;
	}

	public Map<Integer, List<String>> getBuurStedenPerAfstandInterval(String van) {
		Map<Integer, List<String>> uit = new TreeMap<Integer, List<String>>();

		List<String> buren = getBuurSteden(van);

		for (String buur : buren) {
			int afstandCategorie = (int) (afstanden.get(new TweeSteden(van, buur)).doubleValue()) / 50;
			if (!uit.containsKey(afstandCategorie)) {
				List<String> lijst = new ArrayList<>();
				lijst.add(buur);
				uit.put(afstandCategorie, lijst);
			} else {
				List<String> lijst = uit.get(afstandCategorie);
				lijst.add(buur);
				Collections.sort(lijst);
			}
		}

		return uit;
	}

	private List<String> getBuurSteden(String van) {
		van = van.toLowerCase();
		List<String> lijst = new ArrayList<>();
		if (van != null) {
			for (TweeSteden steden : this.afstanden.keySet()) {
				String stad = null;
				if (van.equalsIgnoreCase(steden.getVan())) {
					stad = steden.getNaar();
				} else if (van.equalsIgnoreCase((steden.getNaar()))) {
					stad = steden.getVan();
				}
				if (stad != null) {
					lijst.add(stad);
				}
			}
		}
		return lijst;
	}

	public String getOverzichtBuurStedenPerAfstandInterval(String van) {
		Map<Integer, List<String>> stedenTot = this.getBuurStedenPerAfstandInterval(van);
		String uit = "";
		for (Integer k : stedenTot.keySet()) {
			uit += "\nAfstand van " + (k * 50) + " km :";
			for (String s : stedenTot.get(k)) {
				uit += s + "\t";
			}
			uit += "\n";
		}
		return (uit.length() == 0 ? "geen afstanden van " + van : uit);

	}

	public String getOverzichtTraject(String trajectString) {
		return "";
	}

	public String getOverzichtTraject(Collection<String> steden) {
		return "";
	}

	public int getAantalAfstanden() {
		return afstanden.size();
	}

	public Set<Entry<TweeSteden, Double>> iterator() {
		return this.afstanden.entrySet();
	}

	public Double getAfstand(TweeSteden key) {
		return this.afstanden.get(key);
	}

}
