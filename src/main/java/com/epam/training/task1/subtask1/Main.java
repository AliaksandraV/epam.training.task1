package com.epam.training.task1.subtask1;

import java.util.Scanner;

/**
 * Разработайте программу, которая проверяет, что числа a, b и c различны (одинаковы).
 */
public class Main {
    private static String enterA = "Введите a = ";
    private static String enterB = "Введите b = ";
    private static String enterC = "Введите c = ";

    public static void main(String[] args) {
        int a = enterNumber(enterA);
        int b = enterNumber(enterB);
        int c = enterNumber(enterC);
        checkNumbers(a, b, c);
    }

    private static int enterNumber(String label) {
        int number;

        Scanner in = new Scanner(System.in);
        System.out.println(label);

        System.out.print("");
        while (!in.hasNextInt()) {
            System.out.println("Неверные данные. Введите целое число.");
            System.out.print(label);
            in.next();
        }
        number = in.nextInt();
        return number;
    }

    private static void checkNumbers(int a, int b, int c) {
        if (a == b && b == c) {
            System.out.println("Все значения равны.");
        } else if (a == b) {
            System.out.println("Значения a и b равны.");
        } else if (a == c) {
            System.out.println("Значения a и c равны.");
        } else if (b == c) {
            System.out.println("Значенмя b и c равны.");
        } else {
            System.out.println("Все значения различны.");
        }
    }
}
