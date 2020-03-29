package ru.netology;

import java.util.Random;

public class CitiesGenerator {
    public static String getRandomCities() {
        String[] citiesCollection = {"Харьков", "Минск", "Москва", "Тамбов"};
        Random random = new Random();
        int index = random.nextInt(citiesCollection.length);
        return (citiesCollection[index]);
    }
}
