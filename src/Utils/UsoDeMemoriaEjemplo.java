public class UsoDeMemoriaEjemplo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        // Garbage collect para precicion en la recleccion de memoria
        runtime.gc();
        long memoryantes = runtime.totalMemory() - runtime.freeMemory();

        // Codigo a ejecutar
        tareaejemplo();
        // Garbage collect para precicion en la recleccion de memoria
        runtime.gc();
        long memorydespues = runtime.totalMemory() - runtime.freeMemory();

        long memoryUsed = memorydespues - memoryantes;
        System.out.println("Memoria usada en bytes: " + memoryUsed);
    }

    private static void tareaejemplo() {
        // Uso de memoria simpulado
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}
