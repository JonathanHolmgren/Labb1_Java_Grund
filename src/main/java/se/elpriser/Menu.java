package se.elpriser;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void startMenu(){
        String menuOption;
        DailyPrice[] dailyPricesPerHour = InputPrices.getDailyPrices();

        do {
            System.out.println();
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4)");
            System.out.println("5. Ladda in testfil");
            System.out.println("e. Avsluta");
            menuOption = menuOption();

            switch (menuOption) {
                case "1":
                    InputPrices.inputDailyPrices();
                    break;
                case "2":
                    MinMaxAvgPrice.MinMaxAvgP();
                    break;
                case "3":
                    SortPrices.SortedDailyPrices(dailyPricesPerHour);
                    break;
                case "4":
                    BestChargeTime.bestChargeTime(dailyPricesPerHour);
                    break;
                case "5":
                    dailyPricesPerHour = ReadCsvFile.readFile();
                    break;
                case ("e"):
                    System.out.print("Avsluta");
                    break;
                default:
                    System.out.print("Default");
            }
        } while (!menuOption.equals("e"));
    }

    public static String menuOption() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Välj menyval: ");
        return scanner.next().toLowerCase();
    }


}
