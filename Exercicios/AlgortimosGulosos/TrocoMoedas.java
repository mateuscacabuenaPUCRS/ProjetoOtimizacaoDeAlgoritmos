import java.util.ArrayList;
import java.util.List;

public class TrocoMoedas {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Integer> moedasUsadas = troco(2.89);
        System.out.println("foram usadas estas moedas para o troco: " + moedasUsadas);
    }

    public static List<Integer> troco(double valor) {
        System.out.println('\n' + "Valor: " + valor);
        int[] moedas = { 100, 25, 10, 5, 1 };
        List<Integer> moedasUsadas = new ArrayList<>();

        double valorRestante = valor * 100;
        int i = 0;
        while (i != moedas.length) {
            if (moedas[i] < valorRestante) {
                valorRestante -= moedas[i];
                moedasUsadas.add(moedas[i]);
            } else {
                i++;
            }
        }
        return moedasUsadas;
    }
}