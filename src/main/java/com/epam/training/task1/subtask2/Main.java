package com.epam.training.task1.subtask2;


import java.util.Scanner;

/**
 * Масса динозавра задаётся в килограммах. Разработайте программу, которая вычисляет,
 * сколько это миллиграмм, грамм и тонн.
 */
public class Main {

    public static void main(String[] args) {
        double weight = enterWeight();
        print(weight);
    }

    private static double enterWeight() {
        double weight = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите вес динозавра в килограммах: ");
            while (!in.hasNextDouble()) {
                System.out.println("Неверные данные. Введите целое число.");
                System.out.print("Повторите ввод: ");
                in.next();
            }
            weight = in.nextInt();
        } while (weight <= 0);

        return weight;
    }

    private static double countMilligram(double weight) {
        return weight * 1000000;
    }

    private static double countGram(double weight) {
        return weight * 1000;
    }

    private static double countTon(double weight) {
        return weight * 0.001;
    }

    private static void print(double weight) {
        System.out.print("Вес динозавра в миллиграммах: ");
        System.out.println(String.format("%.2f", countMilligram(weight)));
        System.out.print("Вес динозавра в граммах: ");
        System.out.println(String.format("%.2f", countGram(weight)));
        System.out.print("Вес динозавра в тоннах: ");
        System.out.println(String.format("%.3f", countTon(weight)));
    }
}
