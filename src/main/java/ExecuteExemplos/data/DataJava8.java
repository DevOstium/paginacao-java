package ExecuteExemplos.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DataJava8 {

	public static void main(String[] args) {
	
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("LocalDate: " + hoje.format(formatador)); //08/04/2014

		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
		System.out.println("LocalDateTime: " + agora.format(format)); //08/04/14 10:02
		
	}
	
}
