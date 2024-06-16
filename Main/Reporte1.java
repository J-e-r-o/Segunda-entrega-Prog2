package Main;

import src.uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.adt.linkedlist.MyList;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Reporte1 {

    public static void reporet1(){

        String csvFile = "universal_top_spotify_songs.csv";
        String line;
        String csvSplitBy = ",";

        MyList<NodoCancion1> respuesta = new MyLinkedListImpl<>();


        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Eliga un pais: ");
        String pais = scanner1.nextLine();
        System.out.println("Eliga una dia: ");
        String dia_desordenado = scanner1.nextLine();

        //Aca se modifica el string de YYYY-MM-DD a MM/DD/YYYY
        String dia="";
        if(dia_desordenado.charAt(5) != '0'){
            dia=dia + dia_desordenado.charAt(5);
        }
        dia=dia + dia_desordenado.charAt(6)+"/";
        if(dia_desordenado.charAt(8) != '0'){
            dia=dia + dia_desordenado.charAt(8);
        }
        dia=dia+dia_desordenado.charAt(9)+"/"+dia_desordenado.substring(0,4);

        System.out.println(dia);




        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy, -1); // Using -1 to include trailing empty strings

                if (isHeader) {
                    isHeader = false;
                    continue;
                }


                String name = columns[1];
                String artists = columns[2];
                String dailyRank = columns[3];
                String country = columns[6];
                String snapshotDate = columns[7];


                if (country.equals(pais) && snapshotDate.equals(dia)) {
                    NodoCancion1 cancion = new NodoCancion1(name, artists, dailyRank, country, snapshotDate);
                    respuesta.add(cancion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Todo lo que da la respuesta, FALTAN COSAS
        for (int j=0; j< respuesta.size(); j++){
            System.out.println(respuesta.get(j).toString());
        }



        //Deberia servir, pero no sirve
        for (int i=0;i<11;i++) {
            for (int j=0; j< respuesta.size(); j++){
                String top = Integer.toString(i);
                if (respuesta.get(j).dailyRank.equals(top)){
                    System.out.println(respuesta.get(j).toString());
            }
            }
        }

    }
}


















