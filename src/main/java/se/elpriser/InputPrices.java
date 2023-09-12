package se.elpriser;

import java.util.Scanner;


public class InputPrices {

    private static DailyPrice[] dailyPrices = new DailyPrice[24];

    public static DailyPrice[] getDailyPrices() {
        return dailyPrices;
    }

    public static void inputDailyPrices() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Fyll i priserna för dygnets timmar i ören.");

        for (int i = 0; i <= 23; i++) {
            DailyPrice PricePerHour = new DailyPrice();
            String fromTime = String.format("%02d", i);
            String toTime = String.format("%02d", i + 1);
            System.out.print("Kl " + fromTime + " - " + toTime + ":");
            PricePerHour.price = Integer.parseInt(scanner.next().toLowerCase());
            //PricePerHour.time = "Kl " + i + " - " + (i + 1) + ":";
            PricePerHour.fromTime = fromTime;
            PricePerHour.toTime =  toTime;

            dailyPrices[i] = PricePerHour;

        }

    }
}
