package com.epam.training.task1.subtask3;

import java.util.Scanner;

/**
 * На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).
 * Разработайте программу нахождения площади кольца, внешний радиус которого равен R1,
 * а внутренний радиус равен R2.
 */
public class Main {

    public static void main(String[] args) {
        double r1 = enterRadius(1);
        double r2 = enterRadius(2);

        double square1 = countSquare(r1);
        double square2 = countSquare(r2);

        double ringSquare = countRingSquare(square1, square2);

        print(ringSquare);
    }

    private static double enterRadius(int i) {
        double radius;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите радиус " + i + " круга: ");
            while (!in.hasNextDouble()) {
                System.out.println("Неверные данные.");
                System.out.print("Повторите ввод: ");
                in.next();
            }
            radius = in.nextDouble();
        } while (radius <= 0);

        return radius;
    }

    private static double countSquare(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double countRingSquare(double square1, double square2) {
        return Math.abs(square1 - square2);
    }

    private static void print(double ringSquare) {
        if (ringSquare == 0) {
            System.out.println("!");
            System.out.println("Кольца нет, площади кругов одинаковые.");
        } else {
            System.out.println(String.format("%.4f", ringSquare));
        }
    }
}
