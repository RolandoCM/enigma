package extras;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Convierte {

	public Convierte() {
    }

    public static Integer aInteger(String s) {
        Integer result = null;

        if (s != null) {
            try {
                result = Integer.valueOf(s);
            } catch (NumberFormatException ex) {
            }
        }

        return result;
    }

    public static Double aDouble(String s) {
        Double result = null;

        if (s != null) {
            try {
                result = Double.valueOf(s);
            } catch (NumberFormatException ex) {
            }
        }

        return result;
    }
    public static String fechaString(Date fecha)
    {
        String fechaString = "0000-00-00";
        if(fecha!=null)
        {
            DateFormat miFecha = new SimpleDateFormat("yyyy-MM-dd");
            fechaString = miFecha.format(fecha);
        }
 
        return fechaString;
    }
    public static  String fechaBase (String fecha)
    {
        //System.out.println(fecha);
        String newFecha="";
        String arrayFecha [] = fecha.split("/");
        newFecha=arrayFecha[2]+"-"+arrayFecha[1]+"-"+arrayFecha[0];
        
        return newFecha;
        
    }
	
}
