package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 *
 *
 *
 * */


public class ReorderList143 {



    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }



    public static void main(String[] args) {



        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);


        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        reorderList(n1);






    }


    public static void reorderList(ListNode head) {


        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }


        int pointer1=0;
        int pointer2=list.size()-1;

        while(pointer1<pointer2){


            ListNode curr = list.get(pointer1++);
            ListNode tail = list.get(pointer2--);
            tail.next=curr.next;
            curr.next=tail;


        }

        list.get(pointer1).next=null;

    }

/*Note: Nothing to state
*
*
*
* */


}
