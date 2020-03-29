package ru.netology;

import java.util.Random;

public class NamesGenerator {
    public static String getRandomNames() {
        String[] namesCollection = {"Ирина", "Алексей", "Ольга", "Альберт", "Василий"};
        Random random = new Random();
        int index = random.nextInt(namesCollection.length);
        return (namesCollection[index]);
    }
}
