package src;

import src.Entities.*;
import src.uy.edu.um.adt.linkedlist.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static src.Utils.UploadEntities.addSong;
import static src.Utils.Operations.*;

/*
TO DO LIST:

Cargar datos en entries
Hacer logica con heap para sacar los tops de canciones y artistas
Testear que funcione
* */


public class Main{
    public static void  main(String [] args){
        MyList<Song> songs = new MyLinkedListImpl<Song>();
        MyList<Entry> entries = new MyLinkedListImpl<Entry>();

        String csvFile ="universal_top_spotify_songs.csv" ;
        String line = "";
        String delimiter = ",";

        int[] songData = {0, 1, 12, 23};


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                boolean canLoadData = true;
                for (int i = 0; i < songData.length; i++) {
                    if (columns[songData[i]].isEmpty()) {
                        canLoadData = false;
                    }
                }

                if (canLoadData) {
                    addSong(songs, columns);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


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
                        /*System.out.println("Ingrese un dia (YYYY-MM-DD): ");
                        Date newInputDate = scanner.next();
                        System.out.println("Ingrese un país: ");
                        String newInputCountry = scanner.next();

                        top10SongsFromCountryAndDate(entries, newInputCountry, newInputDate);*/
                        break;
                    case 2:
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
                            artistInTop50GivenDate(entries, parsedDate, artist);
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
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat(scanner.next());
                        Date firstDate = dateFormat2.parse(scanner.next());
                        System.out.println("Entre: ");
                        System.out.println("Ingrese una fecha de fin: ");
                        SimpleDateFormat dateFormat3 = new SimpleDateFormat(scanner.next());
                        Date secondDate = dateFormat3.parse(scanner.next());
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
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        scanner.close();
    }
}