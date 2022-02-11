package test;

import uf.UF;
import uf.UF_Tree;

import java.util.Scanner;

/**
 * 并查集测试
 */
public class UFTreeTest {
    public static void main(String[] args) {
        //创建并查集对象
        UF_Tree uf = new UF_Tree(5);
        System.out.println("默认情况下，并查集中有:"+uf.count()+"个分组");
        //从控制台录入两个要合并的元素，调用union合并，观察合并后并查集的分组 是否减少
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("输入第一个要合并的元素");
            int p = sc.nextInt();
            System.out.println("输入第二个要合并的元素");
            int q = sc.nextInt();

            //判断这两个元素是否已经在同一组了
            if(uf.connected(p,q)){
                System.out.println(p+"元素和"+q+"已经在同一组了");
                continue;
            }

            uf.union(p,q);
            System.out.println("当前并查集中还有"+uf.count()+"个分组");
        }
    }
}
