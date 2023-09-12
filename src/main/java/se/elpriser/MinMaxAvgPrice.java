package se.elpriser;


public class MinMaxAvgPrice {

    public static void MinMaxAvgP() {
        DailyPrice[] dailyPricesPerHour = InputPrices.getDailyPrices();
        System.out.println();

        String minPrice = getMinPrice(dailyPricesPerHour);
        System.out.println(minPrice);

        String maxPrice = getMaxPrice(dailyPricesPerHour);
        System.out.println(maxPrice);

        int avgPrice = getAvgPrice(dailyPricesPerHour);
        System.out.println("Medelpriset för dygnet var " + avgPrice + " öre per kWh");
    }

    public static String getMinPrice(DailyPrice[] dailyPricesPerHour) {

        int minPrice = dailyPricesPerHour[0].price;
        //String time = dailyPricesPerHour[0].time;
        String fromTime = dailyPricesPerHour[0].fromTime;
        String toTime = dailyPricesPerHour[0].toTime;


        for (int i = 0; i < dailyPricesPerHour.length; i++) {

            if (dailyPricesPerHour[i].price < minPrice) {
                minPrice = dailyPricesPerHour[i].price;
                 fromTime = dailyPricesPerHour[i].fromTime;
                 toTime = dailyPricesPerHour[i].toTime;
            }
        }
        return "Lägsta priset för idag var " + minPrice + " öre per kWh" + " och var mellan " + "kl: " + fromTime + "-" + toTime;
    }

    public static String getMaxPrice(DailyPrice[] dailyPricesPerHour) {

        int maxPrice = dailyPricesPerHour[0].price;
        //String time = dailyPricesPerHour[0].time;
        String fromTime = dailyPricesPerHour[0].fromTime;
        String toTime = dailyPricesPerHour[0].toTime;

        for (int i = 0; i < dailyPricesPerHour.length; i++) {

            if (dailyPricesPerHour[i].price > maxPrice) {
                maxPrice = dailyPricesPerHour[i].price;
                //time = dailyPricesPerHour[i].time;
                 fromTime = dailyPricesPerHour[i].fromTime;
                toTime = dailyPricesPerHour[i].toTime;
            }
        }
        return "Högsta priset för idag var " + maxPrice + " öre per kWh" + " och var mellan " + "kl: " + fromTime + "-" + toTime;
    }

    public static int getAvgPrice(DailyPrice[] dailyPricesPerHour) {

        int avgPrice = 0;

        for (int i = 0; i < dailyPricesPerHour.length; i++) {

            avgPrice = avgPrice + dailyPricesPerHour[i].price;
        }

        return avgPrice / dailyPricesPerHour.length;
    }

}

