public class RallyGreedy {

    // Comprimento total da trilha em quilômetros
    private static final int L = 1000;

    // Distância máxima que conseguimos viajar durante o dia em quilômetros
    private static final int D = 200;

    // Array representando as distâncias dos pontos de parada do ponto de partida
    private static final int[] pontosParada = {100, 250, 400, 550, 700, 850, 1000};

    public static void main(String[] args) {
        // Método para verificar as paradas (a ser implementado por você)
        verificarParadas();
    }

    // Método base para estruturar o algoritmo Greedy
    public static void verificarParadas() {
        // Inicialização de variáveis para armazenar o ponto atual e o número de paradas
        int posicaoAtual = 0;  // Começamos no ponto de partida
        int numParadas = 0;

        for (int i = 0; i < pontosParada.length; i++) {
            int proximaParada = pontosParada[i];

            // Verifica se a próxima parada está dentro da distância máxima diária (D)
            if (proximaParada - posicaoAtual <= D) {
                // Se está dentro do limite, atualizamos a posição para este ponto de parada
                posicaoAtual = proximaParada;
                System.out.println("Continuamos até o ponto de parada em " + posicaoAtual + " km.");
            } else {
                // Se não está dentro do limite, temos que acampar na parada anterior
                System.out.println("Acampamos no ponto de parada em " + posicaoAtual + " km.");
                numParadas++;
                
                // Depois de acampar, precisamos avaliar se a próxima parada agora está acessível
                if (proximaParada - posicaoAtual > D) {
                    System.out.println("Não é possível chegar ao próximo ponto de parada. Rally falhou.");
                    return;
                }
                // Atualiza posição para a parada atual para reavaliar o próximo ponto
                posicaoAtual = proximaParada;
            }
        }

        // Verifica se chegamos ao final do rally
        if (posicaoAtual == L) {
            System.out.println("Rally completado com sucesso com " + numParadas + " paradas para acampar.");
        } else if (L - posicaoAtual <= D) {
            System.out.println("Rally completado com sucesso no ponto final em " + L + " km.");
        } else {
            System.out.println("Não foi possível completar o rally.");
        }
    }
}
