package sort;

/**
 * 冒泡排序
 */
public class Bubble {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        int length = a.length;
        //每一次比较都不用比较最后一个
        for(int i =length-1;i>0;i--){
            //比较 交换第j位和后面那一位
            for(int j=0;j<i;j++){
                if(greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    //比较v元素是否大于w元素
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
