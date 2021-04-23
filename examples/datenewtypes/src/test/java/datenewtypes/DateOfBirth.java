package datenewtypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate dateOfBirth;
    private String dateString;
    //    private DateTimeFormatter formatter;
    private String pattern;
    private Locale locale;

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + dateString);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        this.dateOfBirth = LocalDate.parse(dateString, formatter);

        this.dateString = dateString;
        this.pattern = pattern;
        this.locale = locale;
    }

    public DateOfBirth(String dateString, String pattern) {
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        this.dateOfBirth = LocalDate.parse(dateString, formatter);

        this.dateString = dateString;
        this.pattern = pattern;
    }

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public String toString(String pattern) {
        if (pattern == null || pattern.trim().equals("")) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(dateOfBirth);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, locale); //Saturday
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate localDate) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }


    public int countDaysSinceBirth(LocalDate localDate) {
        if (localDate == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        if (localDate.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        int between = (int) ChronoUnit.DAYS.between(dateOfBirth, localDate);
//        if (between < 0){
//            throw new IllegalStateException("Birthdate is in the future!");
//        }
        return between;
    }

    public int countDaysBetween(DateOfBirth date) {
        return (int) ChronoUnit.DAYS.between(this.dateOfBirth, date.dateOfBirth);
    }

    public String findDayOfWeek() {
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("HU"));
    }

    public boolean isWeekDay() {
        int day = dateOfBirth.getDayOfWeek().getValue();
        return day < 6;
    }

    public boolean wasItALeapYear(){
        return false;
    }

    public String findBirthDayOfWeekLater(int year){
        LocalDate now = LocalDate.now();
        long between = ChronoUnit.YEARS.between(dateOfBirth, now);
        if (between < year){
            LocalDate laterDate = dateOfBirth.plusYears(year);
            return laterDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("HU"));
        }
        throw new IllegalArgumentException("Year is in the past");
    }

    public static void main(String[] args) {
        DateOfBirth myBirthDay = new DateOfBirth(1984, 3, 25);
        System.out.println(myBirthDay.findDayOfWeek());
        System.out.println(myBirthDay.isWeekDay());
        System.out.println(myBirthDay.findBirthDayOfWeekLater(40));
    }

}
