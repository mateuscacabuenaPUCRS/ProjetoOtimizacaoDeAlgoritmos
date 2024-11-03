public class RallyGreedy {

    // Comprimento total da trilha em quilômetros
    private static final int L = 1000;

    // Distância máxima que conseguimos viajar durante o dia em quilômetros
    private static final int D = 200;

    // Array representando as distâncias dos pontos de parada do ponto de partida
    private static final int[] pontosParada = {100, 250, 400, 550, 700, 850};

    public static void main(String[] args) {
        long inicio = System.nanoTime();

        verificarParadas();

        long fim = System.nanoTime();

        long duracao = (fim - inicio) / 1_000_000;
        System.out.println("\nTempo de execução: " + duracao + " ms");
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

            if(distanciaProximaParada > D) {
                System.out.println("\nPróxima parada inválida: distância da próxima parada é maior que a distância que conseguimos viajar por dia.");
                break;
            }

            System.out.println("\nPosição atual: " + posicaoAtual + " km");
            System.out.println("Próxima parada: " + proximaParada + " km");
            System.out.println("Distância disponível no dia: " + distanciaDisponivel + " km");
            
            // Verifica se a próxima parada está dentro da distância máxima diária
            if (distanciaDisponivel >= distanciaProximaParada) {
                posicaoAtual = proximaParada;
                distanciaDeHoje += distanciaProximaParada;
                System.out.println("*Continuamos até o ponto de parada em " + posicaoAtual + " km.*");
            } else {
                System.out.println("*Acampamos no ponto de parada em " + posicaoAtual + " km, a distância até o próximo ponto é de " + distanciaProximaParada + " km*");
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
