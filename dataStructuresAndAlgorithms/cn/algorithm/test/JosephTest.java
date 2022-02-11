package test;

/**
 * 约瑟夫问题
 */
public class JosephTest {
    public static void main(String[] args) {
        //解决约瑟夫问题
        //1.构建长度为41的循环链表，存储1-41的值
        //用来记录首节点
        Node<Integer> first = null;
        //用来记录first前的一个结点
        Node<Integer> pre = null;

        for(int i =1;i<=41;i++){
            //如果是第一个结点
            if(i==1){
                first=new Node<>(i,null);
                pre=first;
                continue;
            }
            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next=newNode;
            pre=newNode;
            //如果是最后一个结点，
            // 那么需要让最后一个结点的下一个结点变为first,
            // 变为循环链表了
            if(i==41){
                pre.next=first;
            }
        }
        //2.count计数器 模拟报数
        int count=0;
        //3.遍历循环链表
        //记录每次遍历拿到的结点，默认从首节点开始
        Node<Integer> n = first;
        //记录当前结点的上一个结点
        Node<Integer> before = null;
        while (n.next!=n){
            //模拟报数
            count++;
            //判断当前报数是不是3
            if(count==3){
                //如果是3，则把当前节点删除掉，
                // 打印当前节点，重置count=0，让当前节点n后移
                before.next=n.next;
                System.out.print(n.item+" ");
                count=0;
                n=n.next;
            }else {
                //如果不是3，让before变为当前结点，让当前节点后移
                before=n;
                n=n.next;
            }
        }

        System.out.println(n.item);

    }

    //节点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }
}
