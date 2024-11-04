import java.util.InputMismatchException;
import java.util.Scanner;

public class RallyGreedy {

    // Comprimento total da trilha em quilômetros. Ex.: 1000 km
    private static int L;

    // Distância máxima que conseguimos viajar durante o dia em quilômetros. Ex.:
    // 200 km
    private static int D;

    // Array representando as distâncias dos pontos de parada do ponto de partida
    // Ex.: [100, 250, 400, 550, 700, 850]
    private static int[] pontosParada;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Digite o comprimento total da trilha (L): ");
                L = scanner.nextInt();

                System.out.print("Digite a distância máxima que conseguimos viajar durante o dia (D): ");
                D = scanner.nextInt();

                System.out.print("Digite o número de pontos de parada: ");
                int numPontos = scanner.nextInt();
                pontosParada = new int[numPontos];

                System.out.println("Digite as distâncias dos pontos de parada do ponto de partida:");
                for (int i = 0; i < numPontos; i++) {
                    pontosParada[i] = scanner.nextInt();
                }

                long inicio = System.nanoTime();

                verificarParadas();

                long fim = System.nanoTime();

                long duracao = (fim - inicio) / 1_000_000;
                System.out.println("\nTempo de execuçao: " + duracao + " ms");

                break; // Saia do loop se tudo estiver correto

            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira apenas valores numéricos.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
    }

    public static void verificarParadas() {
        int posicaoAtual = 0;
        int numParadas = 0;
        int distanciaDeHoje = 0;

        System.out.println("\n\nIniciando rally:");

        for (int i = 0; i < pontosParada.length; i++) {
            int proximaParada = pontosParada[i];
            int distanciaProximaParada = proximaParada - posicaoAtual;
            int distanciaDisponivel = D - distanciaDeHoje;

            if (distanciaProximaParada > D) {
                System.out.println(
                        "\nPróxima parada inválida: distância da próxima parada é maior que a distância que conseguimos viajar por dia.");
                break;
            }

            System.out.println("\nPosiçao atual: " + posicaoAtual + " km");
            System.out.println("Próxima parada: " + proximaParada + " km");
            System.out.println("Distância disponível no dia: " + distanciaDisponivel + " km.");

            // Verifica se a próxima parada está dentro da distância máxima diária
            if (distanciaDisponivel >= distanciaProximaParada) {
                posicaoAtual = proximaParada;
                distanciaDeHoje += distanciaProximaParada;
                System.out.println("*Continuamos até o ponto de parada em " + posicaoAtual + " km.*");
            } else {
                System.out.println("*Acampamos no ponto de parada em " + posicaoAtual
                        + " km, a distância até o próximo ponto é de " + distanciaProximaParada + " km*");
                distanciaDeHoje = 0;
                numParadas++;
                i--;
            }
        }

        // Verifica se chegamos ao final do rally
        if (posicaoAtual == L) {
            System.out.println("Rally completado com sucesso com " + numParadas + " paradas para acampar.");
        } else if (L - posicaoAtual <= D) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Rally completado com sucesso no ponto final em " + L + " km.");
            System.out.println("Foram feitas " + numParadas + " paradas.");
            System.out.println("-------------------------------------------------------------");

        } else {
            System.out.println("Não foi possível completar o rally.");
        }
    }
}
