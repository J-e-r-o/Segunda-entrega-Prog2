package Main;

import src.uy.edu.um.adt.binarytree.MySearchBinaryTree;
import src.uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Reporte2 {

    public static void reporet2(){
        Scanner escaner = new Scanner(System.in);
        System.out.println("Elija la fecha (formato YYYY-MM-DD): ");
        String fecha= escaner.nextLine();
        MySearchBinaryTree<String,NodoCancion2> resultado = new MySearchBinaryTreeImpl<>();

        //La ponemos bien a la fecha:

        String dia="";
        if(fecha.charAt(5) != '0'){
            dia=dia + fecha.charAt(5);
        }
        dia=dia + fecha.charAt(6)+"/";
        if(fecha.charAt(8) != '0'){
            dia=dia + fecha.charAt(8);
        }
        dia=dia+fecha.charAt(9)+"/"+fecha.substring(0,4);

        System.out.println(dia);


        //Recorre el CSV

        String csvFile = "universal_top_spotify_songs.csv";
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy, -1); // Using -1 to include trailing empty strings

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String id = columns[0];
                String name = columns[1];
                String artists = columns[2];




                NodoCancion2 cancion = new NodoCancion2(id, artists, name);

                if (!resultado.contains(id)) {
                    resultado.add(id,cancion);
                }
                else{
                    resultado.find(id).apariciones +=1;
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
