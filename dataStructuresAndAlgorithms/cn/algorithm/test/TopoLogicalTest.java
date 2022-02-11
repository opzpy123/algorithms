package test;

import graph.Digraph;
import graph.TopoLogical;
import linear.Stack;

/**
 * 拓扑排序测试
 */
public class TopoLogicalTest {
    public static void main(String[] args) {
        //准备有向图
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0,2);
        digraph.addEdge(0,3);
        digraph.addEdge(1,3);
        digraph.addEdge(3,4);
        digraph.addEdge(4,5);
        digraph.addEdge(2,4);
        //通过topological对象对有向图中的顶点进项排序
        TopoLogical logical = new TopoLogical(digraph);
        //获取顶点的线性表并进行排序
        Stack<Integer> order = logical.order();
        for (Object o : order) {
            System.out.print(o+"-");
        }
    }
}
