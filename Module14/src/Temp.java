import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Temp {

	public static void main(String[] args) throws ParseException {
		String a ="100";
		String b ="200";
		int c = Integer.parseInt(a)  + Integer.parseInt(b);
		System.out.println(c);
		
		String d = "15/02/2014";
		Date d1 = new Date();
		System.out.println(d1);
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Date formattedDate = sd.parse(d);
		System.out.println(formattedDate);
		String day = new SimpleDateFormat("dd").format(formattedDate);
		System.out.println(day);
		
		String month = new SimpleDateFormat("MMM").format(formattedDate);
		System.out.println(month);
		
		String year = new SimpleDateFormat("yyyy").format(formattedDate);
		System.out.println(year);

	}

}
