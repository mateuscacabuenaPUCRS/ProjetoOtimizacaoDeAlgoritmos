import java.util.Random;

public class multiplicaXY {
    private static int iterationCount = 0;

    public static void main(String[] args) {
        System.out.println("Teste com 4 bits:");
        testeMultiplicacao(4);

        System.out.println("Teste com 16 bits:");
        testeMultiplicacao(16);

        System.out.println("Teste com 64 bits:");
        testeMultiplicacao(64);
    }

    public static long multiply(long x, long y, int n) {
        iterationCount++;
        if (n == 1) {
            return x * y;
        } else {
            int m = (int) Math.ceil(n / 2.0);
            long a = x >> m;
            long b = x & ((1L << m) - 1);
            long c = y >> m;
            long d = y & ((1L << m) - 1);

            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);

            return (e << (2 * m)) + ((g + h) << m) + f;
        }
    }

    public static void testeMultiplicacao(int bits) {
        Random rand = new Random();
        long maxVal = (1L << bits) - 1;
        long x = rand.nextLong() & maxVal;
        long y = rand.nextLong() & maxVal;

        System.out.println("x: " + x);
        System.out.println("y: " + y);

        iterationCount = 0;
        long startTime = System.nanoTime();
        long result = multiply(x, y, bits);
        long endTime = System.nanoTime();

        System.out.println("Resultado: " + result);
        System.out.println("Número de iterações: " + iterationCount);
        System.out.println("Tempo gasto (nanosegundos): " + (endTime - startTime));
        System.out.println();
    }
}