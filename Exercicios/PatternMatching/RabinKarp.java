public class RabinKarp {

    private static final int BASE = 256; // Base para o cálculo do hash (ASCII).
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
        String pattern = "abc";
        String text = "ababcababcab";

        System.out.println("\n\n");
        System.out.println("resultado: " + rabinKarp(pattern, text)); // 2
    }
}
