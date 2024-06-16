package Main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void  main(String [] args){

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