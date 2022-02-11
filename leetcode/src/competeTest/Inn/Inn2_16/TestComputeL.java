package competeTest.Inn.Inn2_16;

public class TestComputeL {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int randomNumber = (int)(Math.random()*1000+1);//随机1-1000的整数
        for(int i=0;i<arr.length;i++) {
            arr[i] = randomNumber;
            randomNumber = (int)(Math.random()*1000+1);
        }
        long l = System.currentTimeMillis();
        TestComputeL.computeL(arr);
        System.out.println(System.currentTimeMillis()-l);
        long l1 = System.currentTimeMillis();
        TestComputeL.testComputeL(arr);
        System.out.println(System.currentTimeMillis()-l1);
        long l2 = System.currentTimeMillis();
        TestComputeL.testComputePair(arr);
        System.out.println(System.currentTimeMillis()-l2);
        long l3 = System.currentTimeMillis();
        LeftInversions.computeL(arr);
        System.out.println(System.currentTimeMillis()-l3);


//        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
////        int[] arr = {7, 2, 6, 1, 8, 3, 9};
//        System.out.println("原数组:\n" + Arrays.toString(arr));
//        System.out.println("正确的输出值:");
//        System.out.println(Arrays.toString(TestComputeL.computeL(arr)));
//        System.out.println("测试的输出1");
//        System.out.println(Arrays.toString(TestComputeL.testComputeL(arr)));
//        System.out.println("测试的输出2");
//        System.out.println(Arrays.toString(TestComputeL.testComputePair(arr)));
    }

    public static int[] computeL(int[] A) {
        int N = A.length;
        int[] L = new int[N];
        for (int i = 1; i < N; ++i) {
            // count larger values A[j] to the left of A[i]
            for (int j = 0; j < i; ++j) {
                if (A[j] > A[i]) {
                    ++L[i];
                }
            }
        }
        return L;
    }

    public static int[] testComputeL(int[] A) {
        int N = A.length;
        // Here we do indirect insertion sort.
        // First setup an array B, with B[0]=0 and B[i]==i for 0 <=i<N.
        // Then sort these "pointer" values in B, thinking of
        // B[i] as representing (or pointing to) value A[B[i]].
        // L[i] as result
        // Note that A is not modified.
        int[] L = new int[N];
        int[] B = new int[N];
        for (int i = 1; i < N; ++i)
            for (int j = B[i] = i; j > 0 && A[B[j]] < A[B[j - 1]]; --j) {
                //That the conditions have been met
                ++L[i];
                //swap b[j] b[j-1]
                B[j] ^= B[j - 1];B[j - 1] ^= B[j];B[j] ^= B[j - 1];

            }
        return L;
    }

    static class Pair {
        int v; // a value from array A
        int p; // its position, so A[p]==v

        Pair(int v, int p) {
            this.v = v;
            this.p = p;
        }
    }

    public static int[] testComputePair(int[] A) {
        // Here we do pair-based insertion sort.
        // First setup an array P, so that P[i] is a pair
        // representing (A[i], i), for each index i, 0 <= i < N.
        // Then sort these pair objects by their "value" field.
        // Note that A is not modified.
        int N = A.length;
        int[] L = new int[N];
        Pair[] P = new Pair[N];
        //Create element and index
        for (int i = 0; i < N; ++i)
            P[i] = new Pair(A[i], i);
        // Sort the pairs using insertion sort.
        for (int i = 1; i < N; ++i)
            for (int j = i; j > 0 && P[j].v < P[j - 1].v; --j) {
                //That the conditions have been met
                ++L[i];
                // swap references
                Pair tmp = P[j];
                P[j] = P[j - 1];
                P[j - 1] = tmp;
            }
        return L;
    }
}
