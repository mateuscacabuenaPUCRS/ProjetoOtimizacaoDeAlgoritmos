import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Intervalo implements Comparable<Intervalo> { //ORDENAR SEMPRE PELO MENOR FINAL, QUE NAO SOBREPONHA O OUTRO (VER PELO INICIO)
    int inicio, fim;

    // Construtor para definir um intervalo com início e fim
    public Intervalo(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    // Implementação do método compareTo para ordenar os intervalos pelo término
    @Override
    public int compareTo(Intervalo outro) {
        return Integer.compare(this.fim, outro.fim);
    }

    @Override
    public String toString() {
        return "(" + inicio + ", " + fim + ")";
    }
}

public class SDMGuloso {

    // Algoritmo guloso para encontrar a subcolecao disjunta máxima (SDM)
    public static List<Intervalo> sdmGuloso(List<Intervalo> intervalos) {
        List<Intervalo> X = new ArrayList<>();
        int i = 0;  // Último intervalo adicionado à solução
        int iteracoes = 0; // Contador de iterações

        // Inicialmente ordenamos os intervalos pelo seu término
        Collections.sort(intervalos);

        X.add(intervalos.get(i)); // Adicione sempre o primeiro intervalo
        i++;

        for (int k = 0; k < intervalos.size(); k++) {
            iteracoes++; // Contabiliza uma iteração
            // Verifica se o intervalo atual começa após o fim do último intervalo adicionado
            if (intervalos.get(k).inicio > intervalos.get(i).fim) {
                System.out.println("");
                System.out.printf("%d é maior que %d, portanto adicionará na lista.");
                X.add(intervalos.get(k));

                i = k; // Atualiza o índice do último intervalo selecionado
            }
        }

        // Exibe o número de iterações
        System.out.println("Número de iteracoes: " + iteracoes);
        return X;
    }

    // Função principal para executar exemplos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exemplo 1: Intervalos simples
        List<Intervalo> intervalos1 = new ArrayList<>();
        intervalos1.add(new Intervalo(1, 3));
        intervalos1.add(new Intervalo(2, 5));
        intervalos1.add(new Intervalo(6, 8));

        System.out.println("Exemplo 1: Intervalos = " + intervalos1);
        List<Intervalo> sdm1 = sdmGuloso(intervalos1);
        System.out.println("Subcolecao disjunta máxima: " + sdm1);
        System.out.println();

        // Exemplo 2: Intervalos mais complexos
        List<Intervalo> intervalos2 = new ArrayList<>();
        intervalos2.add(new Intervalo(1, 2));
        intervalos2.add(new Intervalo(2, 4));
        intervalos2.add(new Intervalo(3, 6));
        intervalos2.add(new Intervalo(5, 8));
        intervalos2.add(new Intervalo(7, 9));

        System.out.println("Exemplo 2: Intervalos = " + intervalos2);
        List<Intervalo> sdm2 = sdmGuloso(intervalos2);
        System.out.println("Subcolecao disjunta máxima: " + sdm2);
        System.out.println();

        // Exemplo 3: Intervalos que se sobrepõem
        List<Intervalo> intervalos3 = new ArrayList<>();
        intervalos3.add(new Intervalo(1, 4));
        intervalos3.add(new Intervalo(2, 6));
        intervalos3.add(new Intervalo(4, 7));
        intervalos3.add(new Intervalo(5, 9));
        intervalos3.add(new Intervalo(8, 10));

        System.out.println("Exemplo 3: Intervalos = " + intervalos3);
        List<Intervalo> sdm3 = sdmGuloso(intervalos3);
        System.out.println("Subcolecao disjunta máxima: " + sdm3);
        System.out.println();
        
        scanner.close();
    }
}