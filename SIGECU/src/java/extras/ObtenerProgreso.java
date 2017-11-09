/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rolando
 */
public class ObtenerProgreso {
    public static int progreso(String fechaInicio, String fechaTermino)
    {
        int progreso;
        int total =0;
        Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            String currentDate = ft.format(dNow);
            String c="";
            String FI = "";
            String FT ="";
            for(int i=0; i<currentDate.length();i++)
            {
                if(currentDate.charAt(i)!='-')
                {
                    c+=currentDate.charAt(i);
                    FI+=fechaInicio.charAt(i);
                    FT+=fechaTermino.charAt(i);
                }
            }
            int fechaTerminoI = Integer.parseInt(FT);
            int fechaActual=Integer.parseInt(c);
            int fechaInicioI = Integer.parseInt(FI);
            //System.out.println(fechaTerminoI+" "+fechaActual+" "+fechaInicioI+" "+progreso);
            progreso = fechaActual-fechaInicioI;
            total = fechaTerminoI-fechaInicioI;
            System.out.println(total+" "+progreso);
            double progresoS = ((double)(progreso)/total)*100;
            if(progreso<0)
                progreso = 0;
            
            return (int)progresoS;
    }
    
}
