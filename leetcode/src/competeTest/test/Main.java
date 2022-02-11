package competeTest.test;

public class Main {
    public static void main(String[] args) {
        int water = getWater(20104);
        System.out.println(water);
        long finalNum = 0;
        for (int i=10000;i<=500000;i++){
            finalNum+=getWater(i);
        }
        System.out.println(finalNum);
    }

    public static int getWater(int N){
        String[] split = String.valueOf(N).split("");
        int[] container = new int[split.length];
        for (int i=0;i<split.length;i++){
            container[i]=Integer.parseInt(split[i]);
        }
        Integer tail = null;
        int index;
        for (index=container.length-1;index>0;index--){
            if(container[index]!=0){
                tail=container[index];
            }
        }
        if(tail==null){
            tail=container[0];
        }
        int finalCout=0;
        int min = Math.min(container[0], tail);
        for(int i =0;i<container.length-index;i++){
            if(container[i]>min){
                continue;
            }else {
                finalCout+=min-container[i];
            }
        }
        return finalCout;
    }
}
