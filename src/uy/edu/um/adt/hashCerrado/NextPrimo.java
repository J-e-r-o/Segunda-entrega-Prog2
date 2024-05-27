package src.uy.edu.um.adt.hashCerrado;

public class NextPrimo {
    
    public boolean esPrimo(int number) {
   
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
        
    public int nextPrimo(int number) {
        int next = number + 1;
        while (true) {
            if (esPrimo(next)) {
                return next;
            }
            next++;
        }
    }
        
}