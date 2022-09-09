package ru.steptracker;

public class StepTracker {
    MonthData[] monthToData;
    int targetNumberStep;

    public StepTracker() {
        targetNumberStep = 10000;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setTargetNumberStep (int newTargetNumberStep) {
        targetNumberStep=newTargetNumberStep;
        System.out.println("Значение сохранено! Ваша новая дневная цель " + targetNumberStep + " шагов в день.");
    }

    public void setMonthToData (int day, int month, int numberSteps) {
        monthToData[month].addSteps(day,numberSteps);
    }

    public void printMonthStat (int month) {
        if (month<0) {
            System.out.println("Значение должно быть больше 0");
            return;
        }else if (month>12) {
            System.out.println("Значение должно быть меньше 12");
            return;
        }
        monthToData[month].printSumStepMonth();
        monthToData[month].findTotalMonthStep();
        monthToData[month].findAverageNumbSteps();
        monthToData[month].findDistanceTraveled();
        monthToData[month].findNumbCaloriesBurned();
        monthToData[month].findBestStreak(targetNumberStep);
    }
}





