import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Plovilo {

	private int id;
	private String naziv;
	private int godiste;
	private List<String> cijene;
	private List<Date> datumi;

	public Plovilo(String[] ucitaniRedIzTablice, String[] prviRedIzTablice) throws ParseException {

		this.id = Integer.parseInt(ucitaniRedIzTablice[0]);
		this.naziv = ucitaniRedIzTablice[1];
		this.godiste = Integer.parseInt(ucitaniRedIzTablice[2]);
		this.cijene = UcitajIzTablice.izvadiListuCijenaIzRedaUTablici(ucitaniRedIzTablice);
		this.datumi = UcitajIzTablice.pretvoriPrviRedIzTabliceUListu(prviRedIzTablice);
	}

	public List<String> getCijene() {
		return cijene;
	}

	public void setCijene(List<String> cijene) {
		this.cijene = cijene;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	
	public List<Date> getDatumi() {
		return datumi;
	}

	public void setDatumi(List<Date> datumi) {
		this.datumi = datumi;
	}
	
	public static double izracunajCijenuNajma(int id, String datum, int trajanje) throws IOException, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		int indeks = 0;
		double cijena = 0;
		
		String[] prviRed = {};
		String[] trazeniRed = {};
		
		prviRed = UcitajIzTablice.ucitajPrviRedIzTablice();
		trazeniRed = UcitajIzTablice.ucitajJedanRedIzTablice(id);
		
		Plovilo plovilo = new Plovilo(trazeniRed, prviRed);
		
		Date datumNajma = sdf.parse(datum);
		
		if (plovilo.datumi.contains(datumNajma)) {
			indeks = plovilo.datumi.indexOf(datumNajma);
		}
		if (!(plovilo.datumi.contains(datumNajma))) {
			plovilo.datumi.add(datumNajma);
			Collections.sort(plovilo.datumi);
			indeks = plovilo.datumi.indexOf(datumNajma) - 1;
		}
		
		if (trajanje == 7) {
			cijena = Double.parseDouble(plovilo.getCijene().get(indeks));
			return cijena;
		}
		if (trajanje != 7) {
			cijena = (Double.parseDouble(plovilo.getCijene().get(indeks)) * trajanje) / 7;
			cijena = Math.round(cijena * 100) / 100.0;
			return cijena;
		}

		return cijena;

	}
}
