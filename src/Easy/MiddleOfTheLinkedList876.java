package Easy;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 *
 * */

public class MiddleOfTheLinkedList876 {


    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
            public String toString(){return this.val+"";}
    }


    public static void main(String[] args) {



        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        //head.next.next.next.next.next.next = new ListNode(7);
        //head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println(middleNode(head));

    }



    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;


        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
        

    }

    /*Note:
    * Only 3 mins spent
    * */



}
