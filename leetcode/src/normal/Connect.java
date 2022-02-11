package normal;

import java.util.*;

public class Connect {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		Connect connect = new Connect();
		Node res = connect.connect(node);

	}

	public Node connect(Node root) {
//		//广度优先遍历
//		//双端队列
//		Queue<Node> deque = new LinkedList<>();
//		deque.add(root);
//		Node headNode = root;
//		List<Node> nodeList = new ArrayList<>();
//		while (!deque.isEmpty()) {
//			Node last = deque.poll();
//			nodeList.add(last);
//			if(last.left!=null){
//				deque.add(last.left);
//			}
//			if(last.right!=null){
//				deque.add(last.right);
//			}
//		}
//		int[] num={0,2,6,14,30};
//		int index=0;
//		for (int i = 0; i < nodeList.size()-1; i++) {
//			if(i==num[index]){
//				index++;
//			}else {
//				nodeList.get(i).next=nodeList.get(i+1);
//			}
//		}
//		return headNode;
		if (root == null) {
			return root;
		}

		// 初始化队列同时将第一层节点加入队列中，即根节点
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		// 外层的 while 循环迭代的是层数
		while (!queue.isEmpty()) {

			// 记录当前队列大小
			int size = queue.size();

			// 遍历这一层的所有节点
			for (int i = 0; i < size; i++) {

				// 从队首取出元素
				Node node = queue.poll();

				// 连接
				if (i < size - 1) {
					node.next = queue.peek();
				}

				// 拓展下一层节点
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		// 返回根节点
		return root;

	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};
