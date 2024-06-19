package Main;
import src.uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.adt.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Main{
    public static void  main(String [] args){

        MyList<NodoCancion> canciones = new MyLinkedListImpl<>();

        // Path to your CSV file
        String csvFile ="universal_top_spotify_songs.csv" ;
        String line = "";
        String delimiter = ","; // Adjust the delimiter if needed


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line if your CSV has one
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split the line by the delimiter
                String[] columns = line.split(delimiter);

                // Parse and instantiate NodoCancion
                NodoCancion filaCancion = new NodoCancion(
                        columns[0],                       // spotify_id
                        columns[1],                       // name
                        columns[2],                       // artists
                        (columns[3]),     // daily_rank
                        (columns[4]),     // daily_movement
                        (columns[5]),     // weekly_movement
                        columns[6],                       // country
                        columns[7],                       // snapshot_date
                        (columns[8]),     // popularity
                        columns[9],                       // is_explicit
                        (columns[10]),    // duration_ms
                        columns[11],                      // album_name
                        columns[12],                      // album_release_date
                        (columns[13]),    // danceability
                        (columns[14]),    // energy
                        (columns[15]),    // key
                        (columns[16]),    // loudness
                        (columns[17]),    // mode
                        (columns[18]),    // speechiness
                        (columns[19]),    // acousticness
                        columns[20],                      // instrumentalness
                        (columns[21]),    // liveness
                        (columns[22]),    // valance
                        (columns[23]),    // tempo
                        (columns[24])     // time_signature
                );

                // Add the song object to the list
                canciones.add(filaCancion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    //Esto es un prueba que deberia mostrar las primeras 10 canciones
    for (int i=0; i<10;i++) {
        System.out.println(canciones.get(i).toString());
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
                    "6- Cerrar programa");

                //Tal vez falte hacer un try-catch para cuando el input no es un int.
                int opcion = scanner.nextInt();


                switch (opcion) {
                    case 1:
                        Reporte1.reporet1();
                        break;
                    case 2:
                        Reporte2.reporet2();
                        break;
                    case 3:
                        Reporte3.reporet3();
                        break;
                    case 4:
                        Reporte4.reporet4();
                        break;
                    case 5:
                        Reporte5.reporet5();
                        break;
                    case 6:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opcion invalida, intente de nuevo");
                }
            }
            scanner.close();





    }
}