import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UcitajIzTablice {

	public static String[] ucitajPrviRedIzTablice() throws IOException {
			
			String file = "src\\cjenik.csv";
			BufferedReader reader = null;
			String line = "";
			String[] prviRedIzTablice = {};
			
			try {
				reader = new BufferedReader(new FileReader(file));
				for(int i = 0; i < 1; i++) {
					line = reader.readLine();
					prviRedIzTablice = line.split(",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				reader.close();
			}
			return prviRedIzTablice;
	}
	
	public static ArrayList<Date> pretvoriPrviRedIzTabliceUListu(String[] prviRedIzTablice) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum;
		ArrayList<Date> listaDatuma = new ArrayList<>();
		
		for (int i = 0; i < prviRedIzTablice.length; i++) {
			if (prviRedIzTablice[i].equals("")) {
				continue;
			}
			if (prviRedIzTablice[i].contains("-")) {
				int indexMinusa = prviRedIzTablice[i].indexOf('-');
				prviRedIzTablice[i] = prviRedIzTablice[i].substring(0, indexMinusa);
				datum = sdf.parse(prviRedIzTablice[i]);
				listaDatuma.add(datum);
			}
		}
		return listaDatuma;
	}
	
	public static String[] ucitajJedanRedIzTablice(int idPlovila) throws IOException {
		
		String id = String.valueOf(idPlovila);
		String file = "src\\cjenik.csv";
		BufferedReader reader = null;
		String line = "";
		String[] redUTablici = {};
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				
				redUTablici = line.split(",");
				
				if (!(redUTablici[0].equals(id))) {
					continue;
				} else {
					return redUTablici;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return redUTablici;
	}
	
	public static ArrayList<String> izvadiListuCijenaIzRedaUTablici(String[] redUTablici){
		
		ArrayList<String> cijene = new ArrayList<>();
		
		for (int i = 0; i < redUTablici.length; i++) {
			if (i <= 2) {
				continue;
			}
			cijene.add(redUTablici[i]);
		}
		return cijene;
	}
	
	
}
