import java.util.ArrayList;
import java.util.Random;

public class mergesort {
    private static int iterationCount = 0;

    public static void main(String[] args) {
        // Cria uma lista de inteiros
        ArrayList<Integer> list = new ArrayList<>();

        // Adiciona elementos à lista
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt(100) + 1);
        }
        System.out.println("Lista: " + list);

        // Medir o tempo de execução
        long startTime = System.nanoTime();
        ArrayList<Integer> sortedList = MERGESORT(list);
        long endTime = System.nanoTime();

        // Imprime a lista ordenada
        System.out.println("Lista ordenada: " + sortedList);

        // Imprime o número de iterações e o tempo gasto
        System.out.println("Número de iterações: " + iterationCount);
        System.out.println("Tempo gasto (nanosegundos): " + (endTime - startTime));
    }

    public static ArrayList<Integer> MERGESORT(ArrayList<Integer> list) {
        if (list.size() <= 1) return list;

        // Divide a lista em duas sublistas
        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursivamente ordena as duas metades
        left = MERGESORT(left);
        right = MERGESORT(right);
        return merge(left, right);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Mescla as duas listas ordenadas
        while (i < left.size() && j < right.size()) {
            iterationCount++;
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Adiciona os elementos restantes
        while (i < left.size()) {
            iterationCount++;
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            iterationCount++;
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}