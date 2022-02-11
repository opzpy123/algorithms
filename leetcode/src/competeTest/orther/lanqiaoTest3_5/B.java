package competeTest.orther.lanqiaoTest3_5;

public class B {
    public static void main(String[] args) {
        int count=0;
        for(int i=1;i<=2020;i++){
            System.out.println(i);
            String[] split = String.valueOf(i).split("");
            for (int i1 = 0; i1 < split.length; i1++) {
                if(split[i1].equals("2")){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
