package ru.steptracker;

public class MonthData {
    int[] steps;

    public MonthData() {
        steps = new int[30];
    }

    public void addSteps(int day, int stepsPass) {
        steps[day] = stepsPass;
    }

    public void printSumStepMonth() {
        String print = "";
        for (int i = 0; i < steps.length; i++) {
            print += (i + 1) + " день: " + steps[i];
            if (i != steps.length - 1) {
                print += ", ";
            }
        }
        System.out.println(print);
    }

    public int getTotalMonthStep() {
        int total = 0;
        for (int i = 0; i < steps.length; i++) {
            total = total + steps[i];
        }
        return total;
    }

    public void findTotalMonthStep() {
        System.out.println("Общее количество шагов за месяц: " + getTotalMonthStep());
    }

    public void findAverageNumbSteps() {
        System.out.println("Среднее количество шагов за месяц: " + getTotalMonthStep() / 30);
    }

    public void findDistanceTraveled() {
        System.out.println("Пройденная дистанция за месяц: " + Converter.convertStepsToDistance(getTotalMonthStep())+ " км.");
    }

    public void findNumbCaloriesBurned() {
        System.out.println("Количество сожженных калорий: " + Converter.convertStepsToCal(getTotalMonthStep()));
    }

    public void findBestStreak(int targetNumberStep) {
        int maxCount = 0;
        int counter = 0;
        for (int i = 0; i < steps.length; i++) {
            if (steps[i] >= targetNumberStep) {
                counter++;
            } else if (counter != 0) {
                if (maxCount < counter) {
                    maxCount = counter;
                }
                counter = 0;
            }
        }
        if (maxCount < counter) {
            maxCount = counter;
        }
        System.out.println("Лучшая серия: " + maxCount);
    }
}




