package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AA {
    public static void main(String[] argv) {

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM, yy");
        try {

            Date date = inputFormat.parse("07/06/2013");
            System.out.println(date);
            System.out.println(outputFormat.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
