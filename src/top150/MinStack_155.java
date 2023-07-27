package top150;

public class MinStack_155 {
    public Node head;
    public Node cur;
    public int deep;
    public MinStack_155() {
        head = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        cur = head;
        deep = 0;
    }

    public void push(int val) {
        Node temp = new Node(val, this.getMin());
        temp.left=cur;
        cur.right=temp;
        cur=cur.right;
        deep+=1;
    }

    public void pop() {
        if (deep>0){
            Node nodeLeft = cur.left;
            cur=nodeLeft;
            nodeLeft.right=null;
            deep-=1;
        }
    }

    public int top() {
        return cur.value;
    }

    public int getMin() {
        return cur.minValue;
    }

    class Node {
        public int value;
        public int minValue;
        public Node right;
        public Node left;
        public Node(int value, int preMinValue){
            this.value = value;
            this.minValue = Math.min(preMinValue, value);
        }
    }

    public static void main(String[] args){
        MinStack_155 m = new MinStack_155();
        m.push(2);
        m.push(0);
        m.push(3);
        m.push(0);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}
