package se.elpriser;


public class BestChargeTime {


    public static void bestChargeTime(DailyPrice[] dailyPricesPerHour) {

        DailyPrice[] bestChargesTimes = getbestChargeTime(dailyPricesPerHour);
        printOut(bestChargesTimes);
    }

    public static DailyPrice[] getbestChargeTime(DailyPrice[] dailyPricesPerHour) {

        DailyPrice[] bestChargesTimes = new DailyPrice[4];
        int CheapestCoherentCharging = dailyPricesPerHour[0].price + dailyPricesPerHour[1].price + dailyPricesPerHour[2].price + dailyPricesPerHour[3].price;
        for (int i = 0; i < dailyPricesPerHour.length - 3; i++) {

            int temp = dailyPricesPerHour[i].price + dailyPricesPerHour[i + 1].price + dailyPricesPerHour[i + 2].price + dailyPricesPerHour[i + 3].price;

            if (temp < CheapestCoherentCharging) {

                CheapestCoherentCharging = temp;

                for (int j = 0; j < 4; j++) {
                    bestChargesTimes[j] = dailyPricesPerHour[i + j];
                }
            }
        }
        return bestChargesTimes;
    }

    public static void printOut(DailyPrice[] bestChargesTimes) {


        int price = bestChargesTimes[0].price + bestChargesTimes[1].price + bestChargesTimes[2].price + bestChargesTimes[3].price;
        int avgPrice = price / 4;
        String fromTime = bestChargesTimes[0].fromTime;
        String toTime = bestChargesTimes[3].toTime;

        System.out.println("Billigaste laddningen sker mellan kl: " + fromTime + " och " + toTime + ".");
        System.out.println("Medel priset för varje timme blir " + avgPrice + " ören per kWh");

    }
}
