package test;

import graph.Edge;
import graph.EdgeWeightedGraph;
import graph.KruskalMST;
import graph.PrimMST;
import linear.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * kruskal最小生成树算法测试
 */
public class KrusKalMSTTest {
    public static void main(String[] args) throws IOException {
        //准备一副加权无向图
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(KrusKalMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt"))));
        int total = Integer.parseInt(br.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(total);
        int edgeNums = Integer.parseInt(br.readLine());
        for (int e = 1; e <=edgeNums ; e++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v=Integer.parseInt(str[0]);
            int w=Integer.parseInt(str[1]);
            Double weight=Double.parseDouble(str[2]);

            //构建加权无向边
            Edge edge = new Edge(v, w, weight);
            G.addEdge(edge);

        }
        //创建一个Mst对象，计算加权无向图中的最小生成树
        KruskalMST mst = new KruskalMST(G);
        //获取最小生成树中的所有边
        Queue<Edge> edges = mst.edges();
        //遍历打印所有的边
        for (Edge e : edges) {
            int v = e.either();
            int w = e.other(v);
            double weight = e.weight();
            System.out.println(v+"-"+w+"  "+weight);
        }
    }
}
