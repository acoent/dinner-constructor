package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    static Random rand = new Random();
    String getRandomDish(ArrayList<String> names) {
        return names.get(rand.nextInt(names.size()));
    }
}
