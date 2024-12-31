package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class DinnerConstructor {
    static HashMap<String, ArrayList<String>> dish = new HashMap<>();
    static Random rand = new Random();
    String getRandomDish(ArrayList<String> names) {
        return names.get(rand.nextInt(names.size()));
    }
    void getCombo(int numberOfCombos, ArrayList<String> wishlist){
        for (int j = 1; j <= numberOfCombos; j++) {
            System.out.println("Комбо " + j);
            String combo = "";
            // сгенерируйте комбинации блюд и выведите на экран
            for (String s : wishlist) {
                combo += ", " + getRandomDish(dish.get(s));
            }
            System.out.println(combo.substring(2));
        }
    }
    void addDish(String dishType, String dishName){
        if (!dish.containsKey(dishType)) {
            dish.put(dishType, new ArrayList<>());
        }
        if (!dish.get(dishType).contains(dishName)) {
            dish.get(dishType).add(dishName);
        }
    }
    boolean checkType(String type){
        return dish.containsKey(type);
    }
}
