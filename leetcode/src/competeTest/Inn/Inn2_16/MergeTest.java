package competeTest.Inn.Inn2_16;

import java.util.Arrays;

public class MergeTest {

    public static void main(String[] args) {
        //原数组:
        //[3, 1, 4, 1, 5, 9, 2, 6, 5]
        //正确的输出值:
        //[0, 1, 0, 2, 0, 0, 4, 1, 2]
        System.out.println(Arrays.toString(computeL(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5})));
    }

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


}
