package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurreentDate {

    // Format current date to order date format of MMMM d, yyyy
    public static String dateMMMMDYYYYFormat(){
        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        return dateFormat.format(new Date());
    }



}
