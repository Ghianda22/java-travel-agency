package com.agency.travel;

import com.sun.security.jgss.GSSUtil;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean reload = true;

        while(reload){
            System.out.println("Vuoi inserire una nuova vacanza? y/n");
            String answ = in.nextLine();
            if(answ.equalsIgnoreCase("y")){
                /*boolean dataError = false;
                Vacanza holiday = null;
                while(!dataError){
                    System.out.println("Inserisci la destinazione:");
                    String destination = ;
                    System.out.println("Scegli la data di partenza:");
                    LocalDate departureDay = setDate();
                    System.out.println("Quando ritornerai?");
                    LocalDate returnDay = setDate();
                    try {
                        holiday = new Vacanza(destination, departureDay, returnDay);
                        dataError = false;
                    } catch (InstantiationException e) {
                        System.out.println(e.getMessage());
                        dataError = true;
                    }
                };*/
                Vacanza holiday = new Vacanza();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.printf(
                        "Hai prenotato una vacanza di %d giorni a %s dal %s al %s\n",
                        holiday.holidayDuration(),
                        holiday.getDestination(),
                        holiday.getDepartureDay().format(df),
                        holiday.getReturnDay().format(df)
                );
            }else if(answ.equalsIgnoreCase("n")) {
                reload = false;
            }
            else System.out.println("inserisci 'y' = yes o 'n' = no per fare una scelta");
        }
    }



}
