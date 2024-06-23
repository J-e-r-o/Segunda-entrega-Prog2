public class TiempoDeEjecucion {
    public static void main(String[] args) {
        long tiempoinicial = System.nanoTime();

        // Codigo a ejecutar
        performTask();

        long tiempofinal = System.nanoTime();
        long duracion = (tiempofinal - tiempoinicial); // Divide by 1_000_000 to get milliseconds.
        System.out.println("Tiempo de ejecucion en nanosegundos: " + duracion);
    }

    private static void performTask() {
        // Simulacion de tiempo de ejecucion
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
    }
}