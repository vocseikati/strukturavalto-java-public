package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> birthdays = new ArrayList<>();

    public FamilyBirthdays(LocalDate... birthday) {
        birthdays.addAll(Arrays.asList(birthday));
    }

    public List<LocalDate> getBirthdays() {
        return birthdays;
    }

    public boolean isFamilyBirthday(TemporalAccessor temporal) {
        int month = temporal.get(ChronoField.MONTH_OF_YEAR);
        int day = temporal.get(ChronoField.DAY_OF_MONTH);
        for (LocalDate birthday : birthdays) {
            if (birthday.getMonthValue() == month && birthday.getDayOfMonth() == day) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor temporal) {
        int year = temporal.get(ChronoField.YEAR);
        LocalDate base = LocalDate.of(year, temporal.get(ChronoField.MONTH_OF_YEAR), temporal.get(ChronoField.DAY_OF_MONTH));

        int min = Integer.MAX_VALUE;

        for (LocalDate birthday: birthdays) {
            LocalDate nextBirthday = birthday.withYear(year);
            if (nextBirthday.isBefore(base)) {
                nextBirthday = birthday.withYear(year + 1);
            }
            int diff = (int) ChronoUnit.DAYS.between(base, nextBirthday);
            if (min > diff) {
                min = diff;
            }
        }
        return min;
//        LocalDate temporalDate = LocalDate.from(temporal);
//        int minDay = Integer.MAX_VALUE;
//        for (LocalDate birthday : birthdays) {
//            LocalDate modifiedBirthYear = birthday.withYear(temporalDate.getYear());
//            long diff = ChronoUnit.DAYS.between(temporalDate, modifiedBirthYear);
//            if (diff < 0){
//                modifiedBirthYear = modifiedBirthYear.withYear(1);
//            }
//            if (diff < minDay){
//                minDay = (int) diff;
//            }
//        }
//        return minDay;
    }

}
