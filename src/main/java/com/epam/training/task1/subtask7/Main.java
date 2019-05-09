package com.epam.training.task1.subtask7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Разработайте небольшую цельную программу, которая меняет местами содержимое двух целочисленных
 * переменных a и b, не используя для этого дополнительных переменных.
 */
public class Main {
    private static int a;
    private static int b;

    public static void main(String[] args) {
        a = readAndValidateInput("Введите a = ");
        b = readAndValidateInput("Введите b = ");

        changePlaces(a, b);
    }

    private static int readAndValidateInput(String label) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print(label);
            return in.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Неверный формат числа. Повторите ввод.");
            return readAndValidateInput(label);
        }
    }

    private static void changePlaces(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("Содержимое переменных поменено местами.");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
