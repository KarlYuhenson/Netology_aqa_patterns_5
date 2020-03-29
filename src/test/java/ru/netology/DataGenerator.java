package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataGenerator {

    public static String getFutureDate(int plusDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        LocalDate currentDate = LocalDate.now();
        LocalDate controlDate = currentDate.plusDays(plusDate);
        String formattedControlDate = controlDate.format(formatter);
        return formattedControlDate;
    }
}