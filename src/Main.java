import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class Main {
	
	public Main() throws IOException, ParseException {
		
		int id = 2;
		String datumNajma = "20.06.2021";
		int trajanje = 5;
		double cijenaNajma = Plovilo.izracunajCijenuNajma(id, datumNajma, trajanje);
		System.out.println("Cijena najma plovila ID " + id +
				" za polazni datum " + datumNajma + 
				" u trajanju od " + trajanje + " dana iznosi: " + cijenaNajma);
	}

	public static void main(String[] args) throws IOException, ParseException {
		
		new Main();
	}

}
