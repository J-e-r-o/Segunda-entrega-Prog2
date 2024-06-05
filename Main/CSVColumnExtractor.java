package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class CSVColumnExtractor {

        public static void main(String[] args) {
            String spotify = "universal_top_spotify_songs.csv";
            String line;
            String cvsSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(spotify))) {
                List<String[]> extractedData = new ArrayList<>();
                boolean isHeader = true;
                int artistIndex = -1;
                int nameIndex = -1;

                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(cvsSplitBy);

                    // Process header line to find the indices of "artist" and "name"
                    if (isHeader) {
                        for (int i = 0; i < columns.length; i++) {
                            if (columns[i].equalsIgnoreCase("artists")) {
                                artistIndex = i;
                            } else if (columns[i].equalsIgnoreCase("name")) {
                                nameIndex = i;
                            }
                        }
                        isHeader = false;
                        if (artistIndex == -1 || nameIndex == -1) {
                            System.out.println("Required columns not found in the CSV file.");
                            return;
                        }
                    } else {
                        String artist = columns[artistIndex];
                        String name = columns[nameIndex];
                        extractedData.add(new String[]{artist, name});
                    }
                }

                // Print extracted data
                for (String[] data : extractedData) {
                    System.out.println("Artist: " + data[0] + ", Name: " + data[1]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



