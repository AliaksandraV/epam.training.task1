package com.epam.training.task1.subtask6;

import java.util.Scanner;

/**
 * Написать программу, которая переворачивает (реверсирует) семизначное число N
 * (к примеру, число 1234567 реверсируется в число 7654321).
 */
public class Main {

    public static void main(String[] args) {

        String number = readAndValidateInput();
        int reversedNumber = reverseNumber(number);
        printReversedNumber(reversedNumber);
    }

    private static String readAndValidateInput() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите целое семизначное число: ");
            String numberStr = in.next();
            Integer number = Integer.valueOf(numberStr);
            if (number < 1000000 || number > 9999999) {
                System.out.println("Введено не семизначное число. Повторите ввод.");
                return readAndValidateInput();
            }
            return numberStr;
        } catch (NumberFormatException exception) {
            System.out.println("Неверный формат числа. Повторите ввод.");
            return readAndValidateInput();
        }
    }

    private static int reverseNumber(String number) {
        StringBuilder stringBuilder = new StringBuilder(number);
        stringBuilder.reverse();
        number = stringBuilder.toString();

        return Integer.valueOf(number);
    }

    private static void printReversedNumber(int reversedNumber) {
        System.out.print("Перевернутое число: " + reversedNumber);
    }

}
