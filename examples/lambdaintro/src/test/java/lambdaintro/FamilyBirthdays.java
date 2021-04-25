package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> birthDays = new ArrayList<>();

    public FamilyBirthdays(LocalDate... birthday) {
        Collections.addAll(birthDays, birthday);
    }

    public boolean isFamilyBirthday(TemporalAccessor accessor) {
        int month = accessor.get(ChronoField.MONTH_OF_YEAR);
        int day = accessor.get(ChronoField.DAY_OF_MONTH);
        for (LocalDate birthDay : birthDays) {
            if (birthDay.getMonthValue() == month && birthDay.getDayOfMonth() == day) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor accessor) {
        int year = accessor.get(ChronoField.YEAR);
        LocalDate baseDate = LocalDate.from(accessor);
        int min = Integer.MAX_VALUE;
        for (LocalDate birthDay : birthDays) {
            LocalDate nextBirthday = birthDay.withYear(baseDate.getYear());
            if (nextBirthday.isBefore(baseDate)) {
                nextBirthday = birthDay.withYear(year + 1);
            }
            long diff = ChronoUnit.DAYS.between(baseDate, nextBirthday);
            if (min > diff){
                min = (int) diff;
            }
        }
        return min;
    }
}
