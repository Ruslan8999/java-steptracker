package ru.steptracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker= new StepTracker();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                int month = isValidMonth();
                int day= isValidDay ();
                int numberSteps= isValidStep ();

                stepTracker.setMonthToData(day-1,month-1,numberSteps);

            } else if (userInput == 2) {
                System.out.println("За какой месяц вы хотите получить статистику?");
                int month= scanner.nextInt();

                stepTracker.printMonthStat(month-1);

            } else if (userInput == 3) {
                while (true) {
                    System.out.println("Введите новое целевое значение по количеству шагов в день");
                    int newTargetNumberStep = scanner.nextInt();
                    if (newTargetNumberStep>=0) {
                        stepTracker.setTargetNumberStep(newTargetNumberStep);
                        break;
                    } else {
                        System.out.println("Требуется ввести положительное число");
                    }
                }
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }

    public static int isValidMonth () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите порядковый номер месяца с 1 до 12");
            int month = scanner.nextInt();
            if (month < 1) {
                System.out.println("Не корректный ввод! Номер месяца не может быть меньше 1.");
            } else if (month > 12) {
                System.out.println("Не корректный ввод! Номер месяца должен быть не больше 12.");
            } else {
                return month;
            }
        }
    }

    public static int isValidDay () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите порядковый номер дня месяца с 1 до 30");
            int day = scanner.nextInt();
            if (day < 1) {
                System.out.println("Не корректный ввод! Номер дня месяца не может быть меньше 1.");
            } else if (day > 30) {
                System.out.println("Не корректный ввод! Номер дня месяца должен быть не больше 30.");
            } else {
                return day;
            }
        }
    }

    public static int isValidStep () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите колличество пройденных шагов");
            int step = scanner.nextInt();
            if (step < 0) {
                System.out.println("Не корректный ввод!");
            } else if (step > 30000) {
                System.out.println("Кто то явно приувеличивает))");
            } else {
                return step;
            }
        }
    }
}



