package company.accolite;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {

        Node h1 = new Node(1, new Node(3, new Node(5, new Node(7))));
        Node h2 = new Node(2, new Node(4, new Node(6, new Node(8, new Node(10, new Node(12))))));
        System.out.println(mergeLinkedList(h1, h2));

        // 1, 3 5, 7
        // 2 , 4 , 6,  8, 10, 11 , 12

    }

    static Node mergeLinkedList(Node h1, Node h2) {

        Node temp1 = h1;
        Node temp2 = h2;
        Node joiner = new Node(-1);
        Node preHead = joiner;

        while (temp1 != null && temp2 != null) {
            int value1 = temp1.value;
            int value2 = temp2.value;

            if (value1 <= value2) {
                joiner.next = temp1;//building joiner
                temp1 = temp1.next;//progressing temp1
            } else {
                joiner.next = temp2;//building joiner
                temp2 = temp2.next;//progressing temp2
            }
            joiner = joiner.next;//progressing joiner
        }

        if (temp1 != null) {
            joiner.next = temp1;
        }
        if (temp2 != null) {
            joiner.next = temp2;
        }


        return preHead.next;

    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
