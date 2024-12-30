package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, ArrayList<String>> dish;
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        dish = new HashMap<>();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        if (!dish.containsKey(dishType)) {
            dish.put(dishType, new ArrayList<>());
        }
        if (!dish.get(dishType).contains(dishName)) {
            dish.get(dishType).add(dishName);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        ArrayList<String> wishlist = new ArrayList<>();
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        //реализуйте ввод типов блюд

        while (true) {
            String nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                break;
            }
            if (dish.containsKey(nextItem)) {
                wishlist.add(nextItem);
            }
        }
        for (int j = 1; j <= numberOfCombos; j++) {
            System.out.println("Комбо " + j);
            String combo = "";
            // сгенерируйте комбинации блюд и выведите на экран
            for (String s : wishlist) {
                combo += ", " + dc.getRandomDish(dish.get(s));
            }
            System.out.println(combo.substring(2));
        }
    }
}
