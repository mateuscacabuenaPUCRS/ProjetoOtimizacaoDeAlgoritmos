public class RabinKarpAula {

    private static final int BASE = 256;          // Base para o cálculo do hash (ASCII).
    private static final int MOD = 101; // Número primo para o módulo.

    public static int rabinKarp(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        long patHash = hash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i + M), M);
            if (patHash == txtHash) {
                return i;
            }
        }
        return N;
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (h * BASE + s.charAt(j)) % MOD;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println("\n\nTeste 1: ");
        System.out.println(rabinKarp("ana", "banana"));

        System.out.println("\nTeste 2: ");
        System.out.println(rabinKarp("bye", "hello world"));

        System.out.println("\nTeste 3: ");
        System.out.println(rabinKarp("pattern", "pattern"));

        System.out.println("\nTeste 4: ");
        System.out.println(rabinKarp("$c d#", "a_b$c d#e%f^"));

        System.out.println("\nTeste 5: ");
        System.out.println(rabinKarp("muchlongerpattern", "short"));

        System.out.println("\nTeste 6: ");
        System.out.println(rabinKarp("sensitive", "CaseSensitiveTest"));

        System.out.println("\nTeste 7: ");
        System.out.println(rabinKarp("rabin", "rabin-karp-algorithm"));

        System.out.println("\nTeste 8: ");
        System.out.println(rabinKarp("pattern", "rabinKarp-algorithm-pattern"));

        System.out.println("\nTeste 9: ");
        System.out.println(rabinKarp("aa", "aaaaaa"));

        System.out.println("\nTeste 10: ");
        System.out.println(rabinKarp("ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
    }
}
