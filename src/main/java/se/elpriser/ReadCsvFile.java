// Inte färdig, behöver inte utvärderas.
package se.elpriser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static se.elpriser.InputPrices.getDailyPrices;

public class ReadCsvFile {

    public static DailyPrice[] readFile() {
        DailyPrice[] updatedFile = getDailyPrices();

        String file = "src/main/resources/elpriserTestFil.txt";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                for(int i = 0; i < row.length; i++){
                    DailyPrice dataFromFile = new DailyPrice();

                    dataFromFile.fromTime = row[0];
                    dataFromFile.toTime = row[1];
                    dataFromFile.price = Integer.parseInt(row[2]);

                    updatedFile[i] = dataFromFile;
                }

            }
            System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return updatedFile;
    }

}
