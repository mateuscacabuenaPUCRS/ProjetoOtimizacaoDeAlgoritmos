public class mochila {
    public static void main(String[] args) {
        int capacidade = 50;
        Item[] itens = {
            null, // índice 0 guarda null
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120),
            // new Item(44, 68),
            // new Item(53, 60),
            // new Item(38, 43),
            // new Item(63, 67),
            // new Item(85, 84),
            // new Item(89, 87),
            // new Item(82, 72)
        };

        int valorMaximo = backPackPD(itens.length - 1, capacidade, itens);
        System.out.println("Valor máximo que pode ser carregado na mochila: " + valorMaximo);
    }

    public static int backPackPD(int numProdutos, int capacidade, Item[] itens) {
        int[][] maxTab = new int[numProdutos + 1][capacidade + 1];

        for (int i = 1; i <= numProdutos; i++) {
            for (int j = 1; j <= capacidade; j++) {
                if (itens[i].peso <= j) {
                    maxTab[i][j] = Math.max(
                            maxTab[i - 1][j],
                            itens[i].valor + maxTab[i - 1][j - itens[i].peso]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

        // Imprimir a tabela maxTab
        System.out.println("Tabela de valores:");
        for (int i = 0; i <= numProdutos; i++) {
            for (int j = 0; j <= capacidade; j++) {
                System.out.print(maxTab[i][j] + "\t");
            }
            System.out.println();
        }

        // Rastrear os itens selecionados
        int w = capacidade;
        System.out.println("Blocos selecionados:");
        for (int i = numProdutos; i > 0 && w > 0; i--) {
            if (maxTab[i][w] != maxTab[i - 1][w]) {
                System.out.println("Item " + i + " (Peso: " + itens[i].peso + ", Valor: " + itens[i].valor + ")");
                w -= itens[i].peso;
            }
        }

        return maxTab[numProdutos][capacidade];
    }
}

class Item {
    int peso;
    int valor;

    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }
}