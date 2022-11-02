import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/* Exercise Lists
Write a program that receives the average temperature (°C) of the 6
first months of the year and store them in a list.

After that, calculate the half-yearly average of temperatures and
show all temperatures above this average; and also which
month they occurred (show month name: 1 – January, 2
– February, etc.).
*/

public class TemperatureExercise {
    public static void main(String[] args) {
        List<Temperature> temperatures = new ArrayList<Temperature>();
        Scanner scanner = new Scanner(System.in);
        int numberOfMonths = 6;

        for (int i = 1; i <= numberOfMonths; i++) {
            String monthNumber = showMonthName(i);
            System.out.println("Enter the " + monthNumber + " temperature (°C):");
            temperatures.add(new Temperature(i, scanner.nextDouble()));
        }

        double mediaTemperaturas = calculateAverageTemperatures(temperatures, numberOfMonths);
        System.out.println("=========================");
        System.out.printf("Average of Temperatures: %.2f° Celsius\n", mediaTemperaturas);
        System.out.println("=========================");

        showTemperaturesAboveAverage(temperatures, mediaTemperaturas);
        scanner.close();
    }

    private static void showTemperaturesAboveAverage(List<Temperature> temperatures, double averageTemperatures) {
        Iterator<Temperature> temperatureIterator = temperatures.iterator();

        System.out.println("Temperatures above average: ");
        while (temperatureIterator.hasNext()) {
            Temperature temperature = temperatureIterator.next();
            double degreeCelsius = temperature.getDegreeCelsius();
            String month = showMonthName(temperature.getMonth());

            if (degreeCelsius > averageTemperatures) {
                System.out.printf("%s -> %.2f° Celsius\n", month, degreeCelsius);
            }
        }
        System.out.println("\n=========================");
    }

    static double calculateAverageTemperatures(List<Temperature> temperatures, int numberOfMonths) {
        Iterator<Temperature> temperatureIterator = temperatures.iterator();
        double sumTemperatures = 0.0;

        while (temperatureIterator.hasNext()) {
            double temperature = temperatureIterator.next().getDegreeCelsius();
            sumTemperatures += temperature;
        }
        double averageTemperature = sumTemperatures / numberOfMonths;

        return averageTemperature;
    }

    static String showMonthName(int month) {
        String monthName = "";

        switch (month) {
            case 1:
                monthName = "january";
                break;
            case 2:
                monthName = "february";
                break;
            case 3:
                monthName = "march";
                break;
            case 4:
                monthName = "april";
                break;
            case 5:
                monthName = "may";
                break;
            case 6:
                monthName = "june";
                break;
        }
        return monthName;
    }
}

class Temperature {
    private int month;
    private double degreeCelsius;

    public Temperature(int month, double degreeCelsius) {
        this.month = month;
        this.degreeCelsius = degreeCelsius;
    }

    public int getMonth() {
        return month;
    }

    public double getDegreeCelsius() {
        return degreeCelsius;
    }
}