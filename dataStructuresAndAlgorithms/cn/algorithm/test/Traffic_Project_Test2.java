package test;

import graph.DepthFirstSearch;
import graph.Graph;
import uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 畅通工程
 */
public class Traffic_Project_Test2 {
    public static void main(String[] args) throws IOException {
        //构建一个缓冲读取流BufferedReader

        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("TrafficProjectFile.txt")));
        //读取第一行数据20
        int totalNum = Integer.parseInt(br.readLine());
        //构建一个并查集 长度为第一行数字
        Graph graph = new Graph(totalNum);
        //读取第二行数据7
        int roadNum = Integer.parseInt(br.readLine());
        //循环读取7条道路
        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            //调用addEdge 让两个城市相通
           graph.addEdge(p,q);
        }

        //构建一个深度优先搜索对象，起点设置为顶点9
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 9);

        //调用marked方法判断，8顶点是否与10顶点相通
        boolean marked1 = depthFirstSearch.marked(8);
        boolean marked2 = depthFirstSearch.marked(10);

        System.out.println("8与9相通吗？:"+marked1);
        System.out.println("10与9相通吗？:"+marked2);



    }
}
