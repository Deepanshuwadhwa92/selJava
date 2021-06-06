package util;

import org.openqa.selenium.InvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class CalendarUtil {

    private static Logger log = LoggerFactory.getLogger(CalendarUtil.class);

    /**
     * Calculate the number of days between two dates
     *
     * @param beforeDate - First date
     * @param afterDate  - Second Date
     * @return number of Days - Long
     */
    public Long numberOfDaysBetweenTwoDates(LocalDate beforeDate, LocalDate afterDate) {
        try {
            return ChronoUnit.DAYS.between(beforeDate, afterDate);
        } catch (InvalidArgumentException ex) {
            log.error("Invalid argument / Date value given for finding date difference between beforeDate: {} and afterDate: {}", beforeDate, afterDate);
            return null;
        }
    }

    /**
     * Get a next business day from today exclude Weekend
     */
    public LocalDate getNextBusinessDay() {
        int days = 1;
        LocalDate resultDate = LocalDate.now();
        while (days > 0) {
            resultDate = resultDate.plusDays(1);
            if (Boolean.FALSE.equals(isWeekend(resultDate))) days--;
        }
        return resultDate;
    }

    /**
     * To check a date is weekend
     *
     * @param localDate - date value
     * @return Yes/No
     */
    public Boolean isWeekend(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    /**
     * Adding Number if Days to a date with out considering the Weekend Saturday and Sunday
     *
     * @param date         - The date which you want to add days
     * @param numberOfDays - Number of days
     * @return Date  - The new Business date after adding number of date
     */
    public LocalDate addBusinessDaysToADate(LocalDate date, int numberOfDays) {
        LocalDate resultDate = date;
        while (numberOfDays > 0) {
            resultDate = resultDate.plusDays(1);
            if (Boolean.FALSE.equals(isWeekend(resultDate))) numberOfDays--;
        }
        return resultDate;
    }

    /**
     * Get the name of the day ex: Monday, Tuesday .. etc
     *
     * @param localDate - Date value
     * @return Name of that particular date - String
     */
    public String getDay(LocalDate localDate) {
        return localDate.getDayOfWeek().name();
    }

    /**
     * To check after hours or not [Not considering the Holiday/ Weekends]
     */
    public Boolean afterHours() {
        ZoneId location = ZoneId.of("Australia/Brisbane");
        ZonedDateTime now = Instant.now().atZone(location);
        ZonedDateTime late = ZonedDateTime.of(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 21, 0), location);
        ZonedDateTime early = ZonedDateTime.of(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 8, 0), location);
        return now.isAfter(late) || now.isBefore(early);
    }
}
