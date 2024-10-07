public class fibonacci {
    private static int fiboRecursivoCount = 0;
    private static int fiboCount = 0;
    private static int fiboMemoizadoCount = 0;

    public static void main(String[] args) {
        int n = 16;
        int[] f = new int[n + 1];

        // Recursivo
        long startTime = System.nanoTime();
        System.out.printf("\nFibonacci Recursivo de %d: %d", n, fiboRecursivo(n));
        long endTime = System.nanoTime();
        System.out.printf("\nContagem de chamadas: %d", fiboRecursivoCount);
        System.out.println("\nTempo gasto (nanosegundos): " + (endTime - startTime));
        System.out.println("-----------------------------------");

        // Normal
        long startTime2 = System.nanoTime();
        System.out.printf("\nFibonacci Normal de %d: %d", n, fibo(n));
        long endTime2 = System.nanoTime();
        System.out.printf("\nContagem de chamadas: %d", fiboCount);
        System.out.println("\nTempo gasto (nanosegundos): " + (endTime2 - startTime2));
        System.out.println("-----------------------------------");

        // Memoizado
        long startTime3 = System.nanoTime();
        System.out.printf("\nFibonacci Memoizado de %d: %d", n, fiboMemoizado(f, n));
        long endTime3 = System.nanoTime();
        System.out.printf("\nContagem de chamadas: %d", fiboMemoizadoCount);
        System.out.println("\nTempo gasto (nanosegundos): " + (endTime3 - startTime3));
        System.out.println("-----------------------------------");

        /*
         * O Fibonacci Recursivo tem um crescimento exponencial no número de chamadas, o
         * que o torna muito ineficiente para valores maiores de n.
         * 
         * O Fibonacci Normal é linear, o que o torna extremamente eficiente, com o
         * número de iterações igual ao valor de n.
         * 
         * O Fibonacci Memoizado é muito mais eficiente que o recursivo simples, pois
         * evita recalcular os mesmos valores. Seu número de chamadas cresce de forma
         * muito mais controlada.
         */
    }

    public static int fiboRecursivo(int n) {
        fiboRecursivoCount++;
        if (n == 0 || n == 1)
            return n;

        return fiboRecursivo(n - 1) + fiboRecursivo(n - 2);
    }

    public static int fibo(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            fiboCount++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static int fiboMemoizado(int[] f, int n) {
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return fiboLookUp(f, n);
    }

    public static int fiboLookUp(int[] f, int n) {
        fiboMemoizadoCount++;
        if (f[n] >= 0) {
            return f[n];
        }

        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = fiboLookUp(f, n - 1) + fiboLookUp(f, n - 2);
        }

        return f[n];
    }
}