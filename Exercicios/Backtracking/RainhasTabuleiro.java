import java.util.Scanner;

public class RainhasTabuleiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor de n: ");
        int n = scanner.nextInt();
        scanner.close();
        
        String[][] tabuleiro = new String[n][n];   
        
        // Inicializa a matriz com valores padrão (por exemplo, "-")
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tabuleiro[i][j] = "-";
            }
        }

        tabuleiro = maxRainhas(tabuleiro, n);
        
        // Mostra a matriz
        System.out.println(matrizParaString(tabuleiro));
    }

    public static String[][] maxRainhas(String[][] tabuleiro, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(cabeRainha(tabuleiro, i, j)) {
                    tabuleiro = posicionarRainha(tabuleiro, i, j);
                }
            }
        }
        return tabuleiro;
    }

    public static boolean cabeRainha(String[][] tabuleiro, int linha, int coluna) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[linha][i].equals("Q") || tabuleiro[i][coluna].equals("Q")) {
                return false;
            }
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if ((i + j == linha + coluna || i - j == linha - coluna) && tabuleiro[i][j].equals("Q")) {
                    return false;
                }
            }
        }
        return true;
    }   


    public static String[][] posicionarRainha(String[][] tabuleiro, int linha, int coluna) {
        tabuleiro[linha][coluna] = "Q";

        return tabuleiro;
    }
    
    public static String matrizParaString(String[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}