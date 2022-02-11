package competeTest.Inn.Inn2_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FinalSubmit {
    static class Pair {
        int v; // a value from array A
        int p; // its position, so A[p]==v
        Pair(int v, int p) { this.v = v; this.p = p; }
    }
    // Given array A, compute and return array L.
    public static int[] computeL(int[] A)
    {
        // Here we do pair-based insertion sort.
        // First setup an array P, so that P[i] is a pair
        // representing (A[i], i), for each index i, 0 <= i < N.
        // Then sort these pair objects by their "value" field.
        // Note that A is not modified.
        int N = A.length;
        int[] L = new int[N];
        Pair[] P = new Pair[N];
        for (int i=0; i<N; ++i)
            P[i] = new Pair(A[i], i);
        // Sort the pairs using insertion sort.
        for (int i = 1; i < N; ++i)
            for (int j=i; j>0 && P[j].v < P[j-1].v; --j)
            {
                Pair tmp = P[j]; // swap references
                P[j] = P[j-1];
                P[j-1] = tmp;
                ++L[i];
            }
        return L;
    }

    // Method main() handles the input and output in a fast way,
    // you do not need to modify it.
    public static void main(String[] args) throws IOException
    {
        // Read input array A. We avoid java.util.Scanner, for speed.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // first line
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()); // second line
        for (int i=0; i<N; ++i)
            A[i] = Integer.parseInt(st.nextToken());
        long l = System.currentTimeMillis();
        // Solve the problem!
        int[] L = computeL(A);
        System.out.println(System.currentTimeMillis()-l);
        // Print the output array L, again buffered for speed.
        PrintWriter out = new PrintWriter(System.out);
        out.print(L[0]);
        for (int i=1; i<N; ++i)
            // System.out.print here would be too slow!
            out.print(" " + L[i]);
        out.close();

    }
}
