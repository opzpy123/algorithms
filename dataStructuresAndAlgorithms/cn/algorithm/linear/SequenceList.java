package linear;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 线性表
 */
public class SequenceList<T>implements Iterable {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity){
        //初始化数据
        this.eles = (T[])new Object[capacity];
        //初始化长度
        this.N=0;
    }

    //将一个线性表置空
    public void clear(){
        this.eles=null;
        this.N=0;
    }

    //判断当前线性表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取线性表长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }

    //向线性表中插入元素
    public void insert(T t){
        if(N==eles.length){
            resize(2*N);
        }
        eles[N++]=t;
    }

    //向线性表的第i个元素前插入一个t元素
    public void insert(T t,int i){
        if(N==eles.length){
            resize(2*eles.length);
        }
        N++;
        //先把i索引处及其后面所有元素依次向后移动一位
        for(int index =N-1;index>i;index--){
            eles[index]=eles[index-1];
        }
        //再把t元素放到i索引处
        eles[i]=t;
    }

    //删除指定索引处的元素，并返回该元素
    public T remove(int i){

        if(N<eles.length/4){
            resize(eles.length/2);
        }

        //记录索引i处的值
        T  current = eles[i];
        //让索引i后面的元素依次向前移动一位
        for(int index=i;index<N+1;index++){
            eles[index]=eles[index+1];
        }
        //元素个数减1
        N--;

        return current;
    }

    //查找t元素第一次出现的索引
    public int find(T t){
        for(int i=0;i<N;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    //根据参数newSize重置eles的大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp =eles;
        //创建新数组
        eles=(T[])new Object[newSize];
        //把原数组的数据拷贝到新数组即可
        for (int i = 0; i < N; i++) {
            eles[i]=temp[i];
        }
    }

    @Override
    public Iterator iterator() {

        return new SIterator();
    }
    private class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor=0;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }

        @Override
        public boolean hasNext() {
            return cusor<N;
        }


    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "eles=" + Arrays.toString(eles) +
                ", N=" + N +
                '}';
    }
}
