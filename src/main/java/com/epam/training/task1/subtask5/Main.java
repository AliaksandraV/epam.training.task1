package com.epam.training.task1.subtask5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Написать программу, которая находит арифметическое и геометрическое среднее цифр
 * шестизначного числа N.
 */
public class Main {

    private static final String GEOMETRICAL_LABEL = "Среднее геометрическое введенного числа: ";
    private static final String ARITHMETICAL_LABEL = "Среднее арифметическое введенного числа: ";

    public static void main(String[] args) {
        int number = readAndValidateInput();

        int a = getValueByIndex(number, 0);
        int b = getValueByIndex(number, 1);
        int c = getValueByIndex(number, 2);
        int d = getValueByIndex(number, 3);
        int e = getValueByIndex(number, 4);
        int f = getValueByIndex(number, 5);

        double arithmeticalMean = findArithmeticalMean(a, b, c, d, e, f);
        double geometricMean = findGeometricMean(a, b, c, d, e, f);

        printResult(arithmeticalMean, ARITHMETICAL_LABEL);
        printResult(geometricMean, GEOMETRICAL_LABEL);
    }

    private static int getValueByIndex(int number, int i) {
        String numberStr = Integer.toString(number);
        return Character.getNumericValue(numberStr.charAt(i));
    }

    private static int readAndValidateInput() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите целое шестизначное число: ");
            int number = in.nextInt();
            if (number < 100000 || number > 999999) {
                System.out.println("Введено не шестизначное число. Повторите ввод.");
                return readAndValidateInput();
            }
            return number;
        } catch (InputMismatchException exception) {
            System.out.println("Неверный формат числа. Повторите ввод.");
            return readAndValidateInput();
        }
    }

    private static double findGeometricMean(double a, double b, double c, double d, double e, double f) {
        double multiplication = a * b * c * e * d * f;
        return Math.pow(multiplication, 1.0 / 6);
    }

    private static double findArithmeticalMean(double a, double b, double c, double d, double e, double f) {
        return (a + b + c + e + d + f) / 6;
    }

    private static void printResult(double result, String label) {
        String formatted = String.format("%.2f", result);
        System.out.println(label + formatted);
    }
}
