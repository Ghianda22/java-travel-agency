package com.agency.travel;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Vacanza {

    private Scanner in = new Scanner(System.in);
    private String destination = null;
    private LocalDate departureDay = null;
    private LocalDate returnDay = null;

    /*public Vacanza(String destination, LocalDate departureDay, LocalDate returnDay) throws InstantiationException {
        try{
            checkNotNull(departureDay, returnDay);
            checkNotElapsed(departureDay);
            checkTimeline(departureDay, returnDay);
            this.destination = destination;
            this.departureDay = departureDay;
            this.returnDay = returnDay;
        }catch(NullPointerException | DateTimeException e){
            throw new InstantiationException(e.getMessage());
        }
    }*/

    public Vacanza(){
        boolean dataError = false;
        do {
            try {
                if(destination == null) setDestination();
                if(departureDay == null) setDepartureDay();
                if(returnDay == null) setReturnDay();
                checkNotNull(departureDay, returnDay);
                checkNotElapsed(departureDay);
                checkTimeline(departureDay, returnDay);
                dataError = false;
            } catch (DateTimeException e) {
                System.out.println(e.getMessage());
                departureDay = null;
                returnDay = null;
                dataError = true;
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
                //params already null, at the loop restart they'll be assigned
                dataError = true;
            }
        } while(dataError);
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination() {
        System.out.println("Inserisci la destinazione:");
        this.destination = in.nextLine();
    }
    public LocalDate getDepartureDay() {
        return departureDay;
    }
    public void setDepartureDay() {
        System.out.println("Scegli la data di partenza:");
        this.departureDay = setDate();
    }
    public LocalDate getReturnDay() {
        return returnDay;
    }
    public void setReturnDay() {
        System.out.println("Quando ritornerai?");
        this.returnDay = setDate();
    }

    //date checks
    /*TODO: try to call checks right into the set methods, so to have the set methods complete and ready to be called from another class
    ex. to modify dates after a booking */
    protected void checkNotNull(LocalDate departureDay, LocalDate returnDay) throws NullPointerException{
        if(departureDay == null || returnDay == null)
            throw new NullPointerException("Devi inserire entrambe le date");
    }

    protected void checkNotElapsed(LocalDate departureDay) throws DateTimeException {
        if(LocalDate.now().isAfter(departureDay))
            throw new DateTimeException("Non puoi partire nel passato!\nLa data di partenza è antecedente a oggi");
    }

    protected void checkTimeline(LocalDate departureDay, LocalDate returnDay) throws DateTimeException{
        if(departureDay.isAfter(returnDay))
            throw new DateTimeException("Non puoi andar via prima di arrivare!\nLa data di arrivo e' antecedente la data di partenza");
    }

    public long holidayDuration(){
        return ChronoUnit.DAYS.between(this.departureDay, this.returnDay);
    }

    public LocalDate setDate(){
        while(true){
            System.out.print("Giorno:  ");
            int day = in.nextInt();
            in.nextLine();
            System.out.print("  Mese:  ");
            int month = in.nextInt();
            in.nextLine();
            System.out.print("  Anno:  ");
            int year = in.nextInt();
            in.nextLine();
            try {
                return LocalDate.of(year, month, day);
            } catch (DateTimeException e) {
                System.out.println("Inserisci dei dati validi: giorni da 1 a 31, mesi da 1 a 12");
            }
        }
    }

}
