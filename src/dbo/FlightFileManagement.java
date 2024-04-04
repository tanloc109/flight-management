package dbo;

import dto.Flight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FlightFileManagement {

    final String fileName = "src\\output\\flight.dat";

    public ArrayList readFile() throws Exception {
        ArrayList result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            String thisLine;
            BufferedReader myInput;
            File f = new File(fileName);
            String fullPath = f.getAbsolutePath();
            FileInputStream file = new FileInputStream(fullPath);
            myInput = new BufferedReader(new InputStreamReader(file));
            while ((thisLine = myInput.readLine()) != null) {
                if (!thisLine.trim().isEmpty()) {
                    String[] split = thisLine.split(",");
                    // flightNumber + ", " + departureCity + ", " + destinationCity + ", " + departureTime + ", " + arrivalTime + ", " + avalableSeat;
                    if (result == null) {
                        result = new ArrayList<>();
                    }

                    for (String string : split) {
                        string = string.trim();
                    }
                    Flight flight = null;
                    String flightNumber = split[1];
                    String departureCity = split[2];
                    String destinationCity = split[3];
                    Date departureTime = dateFormat.parse(split[4]);
                    Date arrivalTime = dateFormat.parse(split[5]);
                    int avalableSeat = Integer.parseInt(split[6].trim());
                    flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, avalableSeat);
                    result.add(flight);
                }
            }
            myInput.close();
        } catch (IOException | NumberFormatException ex) {
            throw ex;
        }
        return result;
    }

    public boolean writeFile(ArrayList arr) throws Exception {
        File f;
        FileOutputStream file;
        BufferedWriter myOutput;
        try {
            f = new File(fileName);

            String fullPath = f.getAbsolutePath();
            file = new FileOutputStream(fullPath);
            myOutput = new BufferedWriter(new OutputStreamWriter(file));
            for (int i = 0; i < arr.size(); i++) {
                if (i > 0) {
                    myOutput.newLine();
                }
                myOutput.write((i + 1) + "," + arr.get(i).toString());
            }
            myOutput.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean checkFile() {
        boolean result;
        File f;
        try {
            f = new File(fileName);
            result = f.exists();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

}
