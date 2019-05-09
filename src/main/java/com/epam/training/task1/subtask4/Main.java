package com.epam.training.task1.subtask4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Разработайте программу, которая проверяет, что цифры четырёхзначного числа N образуют
 * возрастающую (убывающую) последовательность (к примеру, число 1357 удовлетворяет условию,
 * т.к. его цифры соответствуют следующему неравенству: 1 < 3 < 5 < 7, т.е. идут в порядке
 * возрастания).
 */
public class Main {

    private static final String NOT_MATCH = "Цифры числа не соответствуют условиям возрастания или убывания.";
    private static final String MATCH_DECREASING = "Цифры числа образуют УБЫВАЮШУЮ последовательность.";
    private static final String MATCH_INCREASING = "Цифры числа образуют ВОЗВРАСТАЮЩУЮ последовательность.";

    public static void main(String[] args) {
        int number = readAndValidateInput();
        int a = getValueByIndex(number, 0);
        int b = getValueByIndex(number, 1);
        int c = getValueByIndex(number, 2);
        int d = getValueByIndex(number, 3);

        check(a, b, c, d);
    }

    private static int getValueByIndex(int number, int i) {
        String numberStr = Integer.toString(number);
        return Character.getNumericValue(numberStr.charAt(i));
    }

    private static int readAndValidateInput() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите целое четырехзначное число: ");
            int number = in.nextInt();
            if (number < 1000 || number > 9999) {
                System.out.println("Введено не четырехзначное число. Повторите ввод.");
                return readAndValidateInput();
            }
            return number;
        } catch (InputMismatchException exception) {
            System.out.println("Неверный формат числа. Повторите ввод.");
            return readAndValidateInput();
        }
    }

    private static void check(int a, int b, int c, int d) {
        if (checkIsIncreasing(a, b, c, d)) {
            System.out.println(MATCH_INCREASING);
        } else if (checkIsDecreasing(a, b, c, d)) {
            System.out.println(MATCH_DECREASING);
        } else {
            System.out.println(NOT_MATCH);
        }
    }

    /**
     * Метод проверяет соответствуют ли цифры числа условиям УБЫВАНИЯ
     */
    private static boolean checkIsDecreasing(int a, int b, int c, int d) {
        return a > b && b > c && c > d;
    }

    /**
     * Метод проверяет соответствуют ли цифры числа условиям ВОЗВРАСТАНИЯ
     */
    private static boolean checkIsIncreasing(int a, int b, int c, int d) {
        return a < b && b < c && c < d;
    }
}
