package sort;

/**
 * 选择排序
 */
public class Selection {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
       int length = a.length;
       for(int i=0;i<=length-2;i++){
           //定义一个变量，记录最小元素所在的索引，默认为第一个元素
           int minIndex = i;
           for(int j=i+1;j<length;j++){
               if( greater(a[minIndex],a[j])){
                   minIndex=j;
               }
           }
           exch(a,i,minIndex);
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
