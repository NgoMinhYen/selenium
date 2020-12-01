package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
    public String convertDateFormat(String inputDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM,yyyy");
        try {

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

