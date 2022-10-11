package com.agency.travel;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public class Vacanza {
    String destination;
    LocalDate departureDay;
    LocalDate returnDay;

    public Vacanza(String destination, LocalDate departureDay, LocalDate returnDay) throws InstantiationException {
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

    }

    //date checks
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

    public holidayDuration(){

    }
}
