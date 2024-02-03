package company.dotdash;

public class LinkedListNumberAddition {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Utility function to print a linked list */
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    // Driver Code
    public static void main(String[] args) {
        LinkedListNumberAddition list = new LinkedListNumberAddition();

        // creating first list
        list.head1 = new Node(1);
        list.head1.next = new Node(2);
        list.head1.next.next = new Node(3);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(5);
        System.out.print("First List is ");
        list.printList(head1);

        // creating a second list
        list.head2 = new Node(6);
        list.head2.next = new Node(7);
        list.head2.next.next = new Node(7);
        System.out.print("Second List is ");
        list.printList(head2);

        Node rs = list.addTwoListsBrute(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }

    private Node addTwoListsBrute(Node head1, Node head2) {

        String headNumber1 = "";
        String headNumber2 = "";

        Node temp1 = head1;
        while (temp1 != null) {
            headNumber1 += temp1.data;
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        while (temp2 != null) {
            headNumber2 += temp2.data;
            temp2 = temp2.next;
        }

        String sum = Integer.parseInt(headNumber1) + Integer.parseInt(headNumber2) + "";
        System.out.println(sum);

        Node dummy = new Node(-1);
        Node tempHead = dummy;
        for (int i = 0; i < sum.length(); i++) {
            dummy.next = new Node(Integer.parseInt("" + sum.charAt(i)));
            dummy = dummy.next;
        }

        return tempHead.next;
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;//save next
            curr.next = prev;//reverse the link

            // advancing prev & curr
            prev = curr;
            curr = next;//eventually curr will become null
        }

        return null;
    }

}