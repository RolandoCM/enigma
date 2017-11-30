/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author rolando
 */
public class ObtenerProgreso {
    public static int progreso(String fechaInicio, String fechaTermino)
    {
        double progreso;
        int anioI=0;
        int anioF=0;
        int mesI=0;
        int mesF=0;
        int diaI=0;
        int diaF=0;
        final long MILISECS = 24*60*60*1000;
        String [] ff = fechaTermino.split("-");
        
        anioF= Integer.parseInt(ff[0]); 
        mesF= Integer.parseInt(ff[1]);
        diaF=Integer.parseInt(ff[2]);
        
        Date hoy = new Date();
        
        String [] fi = fechaInicio.split("-");
        anioI= Integer.parseInt(fi[0]); 
        mesI= Integer.parseInt(fi[1]);
        diaI=Integer.parseInt(fi[2]);
        //Termino
        Calendar calendarF = new GregorianCalendar(anioF, mesF-1, diaF); 
        java.sql.Date fechaF = new java.sql.Date(calendarF.getTimeInMillis());
        //Inicio
        Calendar calendarI = new GregorianCalendar(anioI, mesI-1, diaI); 
        java.sql.Date fechaI = new java.sql.Date(calendarI.getTimeInMillis());


        long diferenciaTotal = ( fechaF.getTime() - fechaI.getTime() )/MILISECS;
        long diferenciaTrascurrida = (hoy.getTime() - fechaI.getTime())/MILISECS;

        progreso= ((double)(diferenciaTrascurrida)/diferenciaTotal)*100;
        if(progreso<0)
            progreso=0;
        return (int)progreso;
    }
    
}