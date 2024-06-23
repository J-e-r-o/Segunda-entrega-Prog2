package src;

import src.Entities.*;
import src.uy.edu.um.adt.linkedlist.*;
import src.uy.edu.um.adt.hashCerrado.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static src.Utils.UploadEntities.addEntry;
import static src.Utils.UploadEntities.addSong;
import static src.Utils.Operations.*;

/*
TO DO LIST:

Cargar datos en entries
Hacer logica con heap para sacar los tops de canciones y artistas
Testear que funcione
Pasar a Hash para carga eficiente
* */


public class Main{
    public static void  main(String [] args){
        hashInterfaze<String, Song> songs = new hash<>(800000);
        hashInterfaze<Song, Entry> entries = new hash<>(1000000);

        String csvFile ="universal_top_spotify_songs.csv" ;
        String line = "";
        String delimiter = ",";


        int[] songData = {0, 1, 12, 23};
        int[] entryData = {3, 6, 7};


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                boolean canLoadData = true;
                boolean canLoadEntry = true;
                for (int i = 0; i < songData.length; i++) {
                    if (columns[songData[i]].isEmpty()) {
                        canLoadData = false;
                    }
                }
                for (int i = 0; i < entryData.length; i++) {
                    if (columns[entryData[i]].isEmpty()) {
                        canLoadEntry = false;
                    }
                }

                if (canLoadData) {
                    addSong(songs, columns);
                }

                if (canLoadEntry) {
                    addEntry(entries, songs, columns);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(songs.size());
        System.out.println(entries.size());




        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Elija cual reporte quiere hacer" + "\n" +
                    "1- Top 10 canciones en un país en un día dado" + "\n" +
                    "2- Top 5 canciones que aparecen en más top 50 en un día dado." + "\n" +
                    "3- Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado" + "\n" +
                    "4- Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada" + "\n" +
                    "5- Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas" + "\n" +
                    "6- Cerrar programa" + "\n");

            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese una fecha: ");
                        SimpleDateFormat dateFormat5 = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateCase1 = dateFormat5.parse(scanner.next());
                        System.out.println("Ingrese un país: ");
                        String newInputCountry = scanner.next();
                        top10SongsFromCountryAndDate(entries, newInputCountry, dateCase1);
                        break;
                    case 2:
                        System.out.println("Ingrese una fecha: ");
                        SimpleDateFormat dateFormat7 = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateCase2 = dateFormat7.parse(scanner.next());
                        top5SongsFromRankingAndDate(entries, dateCase2);
                        break;
                    case 3:
                        break;
                    case 4:
                        try {
                            System.out.println("Ingrese el nombre de un artista: ");
                            String newInputArtist = scanner.next(); //FALTA CHEQUEAR SI EL CANTANTE TIENE MAS DE UNA PALABRA
                            System.out.println("Ingrese un dia (YYYY-MM-DD): ");
                            System.out.println(scanner.next());
                            SimpleDateFormat dateFormat = new SimpleDateFormat(scanner.next());
                            Date parsedDate = dateFormat.parse(scanner.next());
                            Artist artist = new Artist(newInputArtist);
                            //artistInTop50GivenDate(entries, parsedDate, artist);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 5:
                        System.out.println("Ingrese un tempo de inicio: ");
                        float firstTempo = Float.parseFloat(scanner.next());
                        System.out.println("Ingrese un tempo de fin: ");
                        float secondTempo = Float.parseFloat(scanner.next());
                        System.out.println("Ingrese una fecha de inicio: ");
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date firstDate = dateFormat2.parse(scanner.next());
                        System.out.println("Ingrese una fecha de fin: ");
                        Date secondDate = dateFormat2.parse(scanner.next());
                        QuantityOfSongsWithSpecificTempoAndDate(songs, firstTempo, secondTempo, firstDate, secondDate);
                        break;
                    case 6:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opcion invalida, intente de nuevo");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input invalido");
                scanner.next();
            }  catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        scanner.close();
    }
}