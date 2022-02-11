package competeTest.test;

/**
 * Insertion sort
 */
public class Insertion {

    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
       int length  = a.length;
       for(int i=1;i<length;i++){
           for(int j=i;j>0;j--){
               if(greater(a[j-1],a[j])){
                   exch(a,j-1,j);
               }else {
                   break;
               }
           }
       }
    }

    //isV>W?
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    //exchange  a[i],a[j]
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
