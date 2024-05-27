package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "universal_top_spotify_songs.csv"; // universal_top_spotify_songs.csv TIENE que ser el nombre del archivo

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // El archivo se separa por comas
                
                // Aca se hace el procesamiento de los datos:
                for (String field : data) {
                    System.out.print(field + " "); 
                }
                System.out.println(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}