package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {

    public String getDate(String date, String outputFormat){
        return getDate(date, "yyyy-MM-dd", outputFormat);
    }

    public String getDate(String date, String inputFormat, String outputFormat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(inputFormat, Locale.ENGLISH);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(outputFormat, Locale.ENGLISH);
        LocalDate ld = LocalDate.parse(date, dtf);
        return dtf1.format(ld);
    }
}
