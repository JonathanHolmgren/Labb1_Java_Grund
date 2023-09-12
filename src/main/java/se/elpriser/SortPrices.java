package se.elpriser;

import java.util.Arrays;
import java.util.Comparator;

public class SortPrices {

public static void SortedDailyPrices(DailyPrice[] dailyPricesPerHour){

//Making copy because the OG Array need to be sorted by time and not price
    DailyPrice[] CopyDailyPricesPerHour = Arrays.copyOf(dailyPricesPerHour, dailyPricesPerHour.length);
    Arrays.sort(CopyDailyPricesPerHour, Comparator.comparingInt(DailyPrice::getPrice));
    System.out.println("Sorterade elpriser senaste dygnet");
    for (DailyPrice pricePerHour : dailyPricesPerHour) {
        System.out.println("Kl: " + pricePerHour.fromTime + " - " + pricePerHour.toTime + " " + pricePerHour.price);
    }
}

}
