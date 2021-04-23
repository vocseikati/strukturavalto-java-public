package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime rendezvousTime;

    public Rendezvous(String timeString, String pattern) {
        if (timeString.isEmpty()) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string!" + pattern);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        setLocalTime(timeString, formatter);
    }

    public Rendezvous(int hour, int minute) {
        rendezvousTime = LocalTime.of(hour, minute);
    }

    public void setLocalTime(String timeString, DateTimeFormatter formatter) {
        try {
            rendezvousTime = LocalTime.parse(timeString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
    }

    public LocalTime getRendezvousTime() {
        return rendezvousTime;
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.trim().equals("")){
            throw new IllegalArgumentException("Empty pattern string!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return rendezvousTime.format(formatter);
    }

    public int countMinutesLeft(LocalTime base) {
        if (this.rendezvousTime.isBefore(base)){
            throw new MissedOpportunityException("Too late!");
        }
        return (int) ChronoUnit.MINUTES.between(base, this.rendezvousTime);
    }

    public void pushLater(int hour, int minute) {
        rendezvousTime = rendezvousTime.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        rendezvousTime = rendezvousTime.minusHours(hour).minusMinutes(minute);
    }
}
