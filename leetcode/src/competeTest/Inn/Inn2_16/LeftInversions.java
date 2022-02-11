package competeTest.Inn.Inn2_16;


// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
// A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Your Name

// Remember to put your name in the SPCA statement above.
// As given, this is a correct but too-slow solution.
// The I/O in main is fast enough, but computeL is too slow.

// As given, this solution uses ~24N bytes of memory (~4N per array),
// ignoring the memory used for I/O. It uses order N*logN time.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LeftInversions {
    // Given array A, compute and return array L.
    public static int[] computeL(int[] A) {
        int N = A.length;
        int[] L = new int[N];
        int[] help = new int[N];
        // help[] index array of  A
        for (int i = 0; i < N; i++) {
            help[i] = i;
        }
        //computeL
        sort(A, help, L, 0, N - 1);
        return L;
    }

    public static void merge(int[] arr, int[] help, int[] L, int lo, int mid, int hi) {
        // The left and right length of the current layer
        int lLen = mid - lo + 1;
        int rLen = hi - mid;
        //Auxiliary arrays
        int[] LTemp = new int[lLen];
        int[] RTemp = new int[rLen];
        int[] LHelp = new int[lLen];
        int[] RHelp = new int[rLen];

        //Initial Auxiliary arrays
        for (int i = 0; i < lLen; ++i) {
            LTemp[i] = arr[lo + i];
            LHelp[i] = help[lo + i];
        }
        for (int j = 0; j < rLen; ++j) {
            RTemp[j] = arr[mid + 1 + j];
            RHelp[j] = help[mid + 1 + j];
        }

        // Initial indexes
        int i = 0, j = 0, k = lo;
        /* Merge the Auxiliary arrays and Arrays assignment back */
        while (i < lLen || j < rLen) {
            if (i < lLen && j < rLen) {
                if (LTemp[i] <= RTemp[j]) {
                    arr[k] = LTemp[i];
                    help[k] = LHelp[i];
                    i++;
                } else {
                    arr[k] = RTemp[j];
                    help[k] = RHelp[j];
                    //recording L[]
                    L[help[k]] += j + lLen - k + lo;
                    j++;
                }
            } else {
                if (i < lLen) {
                    arr[k] = LTemp[i];
                    help[k] = LHelp[i];
                    i++;
                } else {
                    arr[k] = RTemp[j];
                    help[k] = RHelp[j];
                    j++;
                }
            }
            k++;

        }
    }


    // Merge sort function
    public static void sort(int[] arr, int[] help, int[] L, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            sort(arr, help, L, lo, mid);
            sort(arr, help, L, mid + 1, hi);

            merge(arr, help, L, lo, mid, hi);
        }
    }


    // Method main() handles the input and output in a fast way,
    // you do not need to modify it.
    public static void main(String[] args) throws IOException {
        // Read input array A. We avoid java.util.Scanner, for speed.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // first line
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()); // second line
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(st.nextToken());

        // Solve the problem!
        int[] L = computeL(A);

        // Print the output array L, again buffered for speed.
        PrintWriter out = new PrintWriter(System.out);
        out.print(L[0]);
        for (int i = 1; i < N; ++i)
            // System.out.print here would be too slow!
            out.print(" " + L[i]);
        out.close();
    }
}