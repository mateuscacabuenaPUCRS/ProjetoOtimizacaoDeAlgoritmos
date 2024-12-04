public class RabinKarpTrabalho {
  public final static int d = 10;

  static void search(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
 
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
 
        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
 
        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
 
            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
 
                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println(
                        "Pattern found at index " + i);
            }
 
            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                     + txt.charAt(i + M))
                    % q;
 
                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

  public static void main(String[] args) {
    int q = 101;

    System.out.println("\n\nExecução do Rabin Karp pesquisado:");
    
    System.out.println("\nTeste 1: ");
    search("ana", "banana", q);

    System.out.println("\nTeste 2: ");
    search("bye", "hello world", q);

    System.out.println("\nTeste 3: ");
    search("pattern", "pattern", q);

    System.out.println("\nTeste 4: ");
    search("$c d#", "a_b$c d#e%f^", q);

    System.out.println("\nTeste 5: ");
    search("muchlongerpattern", "short", q);

    System.out.println("\nTeste 6: ");
    search("sensitive", "CaseSensitiveTest", q);

    System.out.println("\nTeste 7: ");
    search("rabin", "rabin-karp-algorithm", q);

    System.out.println("\nTeste 8: ");
    search("pattern", "search-algorithm-pattern", q);

    System.out.println("\nTeste 9: ");
    search("aa", "aaaaaa", q);

    System.out.println("\nTeste 10: ");
    search("ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", q);
  }
}
