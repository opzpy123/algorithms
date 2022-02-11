package test;

import graph.DepthFirstPaths;
import graph.Graph;
import linear.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 路径查找测试
 */
public class DepthFirstPathsTest {
    public static void main(String[] args) throws IOException {
        //构建缓冲读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("road_find.txt")));
        //读取第一行数据：6
        int total = Integer.parseInt(br.readLine());
        //根据第一行数据 构建一幅图Graph
        Graph G = new Graph(total);
        //读取第二行数据
        int edgeNum = Integer.parseInt(br.readLine());
        //继续通过循环读取每一条边关联的两个顶点，调用addEdge方法添加边
        for(int i =1;i<=edgeNum;i++){
            String edge = br.readLine();//0 1
            String[] str = edge.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v,w);
        }
        //构建路径查找对象，并设置起点为0
        DepthFirstPaths paths = new DepthFirstPaths(G, 0);
        //调用pathTo(4)方法，找到从起点0到终点4的路径，返回satck
        Stack<Integer> stack = paths.pathTo(4);
        //遍历栈对象
        for (Object o : stack) {
            System.out.print(o+" ");
        }
    }
}
