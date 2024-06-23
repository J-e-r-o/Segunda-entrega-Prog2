public class TiempoDeEjecucionPromedio {
    public static void main(String[] args) {
        int iteraciones = 10;
        long duraciontotal = 0;

        for (int i = 0; i < iteraciones; i++) {
            long tiempocomienzo = System.nanoTime();

            // Codigo a ejecutar
            tareaejemplo();

            long tiempofinal = System.nanoTime();
            long duration = (tiempofinal - tiempocomienzo);
            duraciontotal += duration;
        }

        long duracionpromedio = duraciontotal / iteraciones;
        System.out.println("Tiempo promedio de ejecucion en nanosegundos: " + duracionpromedio);
    }

    private static void tareaejemplo() {
        // Simulate some execution time
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
    }
}