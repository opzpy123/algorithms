package sort;

/**
 * 插入排序
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

    //第一个元素大则返回True
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    //数组元素i与j交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
