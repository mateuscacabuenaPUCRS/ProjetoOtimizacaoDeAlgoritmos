import java.util.Random;

public class biggest {
    private static int iterationCount = 0;
    public static void main(String[] args) {
        System.out.println("SEM DIVISÃO: ");
        teste();

        System.out.println("COM DIVISÃO: ");
        teste2();
    }

    public static int maiorSemDivisao(int[] vetor) {
        int maior = vetor[0];
        for (int i = 0; i < vetor.length; i++) {
            iterationCount++;
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    public static void teste() {
        // Cria um vetor de 15 inteiros com valores aleatórios entre 1 e 1000
        int[] vetor = new int[15];
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(1000) + 1;
        }

        // Imprime o vetor original
        System.out.print("Vetor original: [");
        for (int num : vetor) {
            System.out.print(num + ", ");
        }
        System.out.print("]");
        System.out.println();

        // Medir o tempo de execução
        long startTime = System.nanoTime();
        int maior = maiorSemDivisao(vetor);
        long endTime = System.nanoTime();

        // Imprime o maior valor
        System.out.println("Maior valor: " + maior);

        // Imprime o número de iterações e o tempo gasto
        System.out.println("Número de iterações: " + iterationCount);
        System.out.println("Tempo gasto (nanosegundos): " + (endTime - startTime));
    }

    public static void teste2() {
        // Cria um vetor de 15 inteiros com valores aleatórios entre 1 e 1000
        int[] vetor = new int[15];
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(1000) + 1;
        }

        // Imprime o vetor original
        System.out.print("Vetor original: [");
        for (int num : vetor) {
            System.out.print(num + ", ");
        }
        System.out.print("]");
        System.out.println();

        // Medir o tempo de execução
        long startTime = System.nanoTime();
        int maior = maiorComDivisao(vetor);
        long endTime = System.nanoTime();

        // Imprime o maior valor
        System.out.println("Maior valor: " + maior);

        // Imprime o número de iterações e o tempo gasto
        System.out.println("Número de iterações: " + iterationCount);
        System.out.println("Tempo gasto (nanosegundos): " + (endTime - startTime));
    }

    public static int maiorComDivisao(int[] vetor) {
        if(vetor.length == 1) return vetor[0];

        int mid = vetor.length / 2;
        int[] left = new int[mid];
        int[] right = new int[vetor.length - mid];

        System.arraycopy(vetor, 0, left, 0, mid);
        System.arraycopy(vetor, mid, right, 0, vetor.length - mid);

        int A = maiorComDivisao(left);
        int B = maiorComDivisao(right);

        iterationCount++;

        return Math.max(A, B);
    }
}
