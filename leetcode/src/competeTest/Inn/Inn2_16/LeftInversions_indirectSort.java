package competeTest.Inn.Inn2_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LeftInversions_indirectSort {
    // Given array A, compute and return array L.
    private static int[] L;
    public static int[] computeL(int[] A)
    {
        int N = A.length;
        // Here we do indirect insertion sort.
        // First setup an array B, with B[0]=0 and B[i]==i for 0 <=i<N.
        // Then sort these "pointer" values in B, thinking of
        // B[i] as representing (or pointing to) value A[B[i]].
        // L[i] as result
        // Note that A is not modified.
        L = new int[N];
        sort(A,0,N-1);
        return L;
    }

    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
                ++L[i];
            }else{
                temp[k++] = a[j++];
            }

        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
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

        // Solve the problem!
        int[] L = computeL(A);

        // Print the output array L, again buffered for speed.
        PrintWriter out = new PrintWriter(System.out);
        out.print(L[0]);
        for (int i=1; i<N; ++i)
            // System.out.print here would be too slow!
            out.print(" " + L[i]);
        out.close();
    }
}
