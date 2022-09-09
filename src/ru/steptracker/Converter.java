package ru.steptracker;

public class Converter {
    private static double longStep = 0.75;
    private static int stepCal = 50;

    public static double convertStepsToDistance (int numberStep) {
        return longStep * numberStep/1000;
    }

    public static int convertStepsToCal (int numberStep) {
        return stepCal * numberStep/1000;
    }

}