package test;

import java.util.*;

/**
 * 二叉树涂色问题
 * 描述：对二叉树进行涂色，涂一个节点会同时改变自身节点，父节点和两个子节点的颜色
 * 问题：计算给整个二叉树上色，需要最少的上色节点数量
 * 开发语言不限
 */
public class BinaryTreeColoring {
	public static void main(String[] args) {
		//构建二叉树

		//测试用例1 单枝叶二叉树
		Node node0 = new Node(0, null, null);
		Node node1 = new Node(0, null, null);
		Node node2 = new Node(0, node1, null);
		Node node3 = new Node(0, node2, null);
		Node root1 = new Node(0, node3, node0);

		//测试用例2 完全二叉树
		Node node5 = new Node(0, new Node(0,null,null), null);
		Node node6 = new Node(0, null, null);
		Node node7 = new Node(0, null, null);
		Node node8 = new Node(0, null, null);
		Node node9 = new Node(0, node6, node5);
		Node node10 = new Node(0, node8, node7);
		Node root2 = new Node(0, node10, node9);

		//测试用例3 随即二叉树
		Node node11 = new Node(0, null, null);
		Node node12 = new Node(0, null, null);
		Node node13 = new Node(0, null, null);
		Node node14 = new Node(0, null, null);
		Node node15 = new Node(0, node12, node11);
		Node node16 = new Node(0, node14, node13);
		Node node17 = new Node(0, node16, node15);
		Node node18 = new Node(0, node17, new Node(0, null, null));
		Node node19 = new Node(0, null, null);
		Node node20 = new Node(0, node18, null);
		Node node21 = new Node(0, null, node19);
		Node node22 = new Node(0, node20, null);
		Node root3 = new Node(0, node22, node21);

		//用例4




		//测试输出
		System.out.println("返回结果为:" + getResult(root1) + "\n\n\n");
		System.out.println("返回结果为:" + getResult(root2) + "\n\n\n");
		System.out.println("返回结果为:" + getResult(root3) + "\n\n\n");
	}

	/**
	 * 算法逻辑实现
	 *
	 * @param root
	 * @return
	 */
	private static int getResult(Node root) {
		// 1 2 4 8 16 32 64
		ArrayList<ArrayList<Node>> elems = getElems(root);
		System.out.println("-------树-------");
		for (int i = 0; i < elems.size(); i++) {
			for (int j = 0; j < elems.get(i).size(); j++) {
				System.out.print(elems.get(i).get(j).isColoring + ",");
			}
			System.out.println();
		}
		System.out.println("----------------");
		//从下至上 两种变化量(dec)的取小值
		return Math.min(getRes(root, elems, 2),getRes(root, elems, 3));


	}

	private void coloring(int deeps,int n){
		if(n==deeps){

		}
	}


	/**
	 *
	 * @param root
	 * @param elems
	 * @param dec
	 * @return
	 */
	private static int getRes(Node root,ArrayList<ArrayList<Node>> elems,int dec){
		int res = 0;
		int deeps = getDeeps(root);
		if (deeps == 0) return 0;
		//模拟染色
		for (int i = deeps - 1; i >= 1; i -= dec) {
			//求二叉树特定层数中元素的个数
			int levelNum = getElems(root).get(i - 1).size();
			res += levelNum;
			//染色逻辑
			for (Node node : elems.get(i - 1)) {
				//染色当前节点和它的子节点
				coloringNode(node);
				//染色当前节点父节点
				//1.寻找当前节点的父节点层及
				if (i - 2 >= 0 && !elems.get(i - 2).isEmpty()) {
					ArrayList<Node> nodes = elems.get(i - 2);
					//遍历寻找父节点
					for (Node node1 : nodes) {
						if (node1.left == node || node1.right == node) {
							//父节点染色
							node1.isColoring = 1;
						}
					}
				}
			}
		}
		//未被染色的节点数目
		int notColoringNum = getNotColoringNum(elems);
		//节点颜色初始化
		for (ArrayList<Node> elem : elems) {
			for (Node node : elem) {
				node.isColoring=0;
			}
		}
		return notColoringNum + res;
	}

	/**
	 * 染色
	 *
	 * @param node
	 */
	public static void coloringNode(Node node) {
		if (null != node) node.isColoring = 1;
		if (null != node.left) node.left.isColoring = 1;
		if (null != node.right) node.right.isColoring = 1;
	}

	/**
	 * 层序遍历获取树中所有元素 按层存放
	 *
	 * @param root
	 * @return
	 */
	public static ArrayList<ArrayList<Node>> getElems(Node root) {
		ArrayList<ArrayList<Node>> allList = new ArrayList<>();
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		if (root == null) {
			return allList;
		}
		q1.add(root);
		while (!q2.isEmpty() || !q1.isEmpty()) {
			ArrayList<Node> list = new ArrayList<>();
			while (!q1.isEmpty() && q1.peek() != null) {
				q2.add(q1.peek());
				list.add(q1.peek());
				q1.remove();
			}
			allList.add(list);
			while (!q2.isEmpty() && q2.peek() != null) {
				if (q2.peek().left != null) {
					q1.add(q2.peek().left);
				}
				if (q2.peek().right != null) {
					q1.add(q2.peek().right);
				}
				q2.remove();
			}
		}
		return allList;
	}


	/**
	 * 看还有几个未被涂色
	 *
	 * @param elems
	 * @return
	 */
	private static int getNotColoringNum(ArrayList<ArrayList<Node>> elems) {
		int res = 0;
		for (int i = 0; i < elems.size(); i++) {
			for (int j = 0; j < elems.get(i).size(); j++) {
				if (elems.get(i).get(j).isColoring == 0) {
					res++;
				}
			}
		}
		return res;
	}

	/**
	 * 获取二叉树深度 从1开始  0代表空树
	 *
	 * @param root
	 * @return
	 */
	public static int getDeeps(Node root) {
		if (null == root) {
			return 0;
		} else {
			int left = getDeeps(root.left);
			int right = getDeeps(root.right);
			return Math.max(left, right) + 1;
		}
	}


	/**
	 * ----------------树结构----------------
	 */
	private static class Node {
		//存储值 0未涂色 1已涂色
		private int isColoring;
		//记录左子节点
		public Node left;
		//记录右子节点
		public Node right;

		public Node(int isColoring, Node left, Node right) {
			this.isColoring = isColoring;
			this.left = left;
			this.right = right;
		}
	}
	/**
	 * ----------------树结构----------------
	 */
}
