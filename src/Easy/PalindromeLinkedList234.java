package Easy;

import java.util.ArrayList;
/**
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 * */

public class PalindromeLinkedList234 {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public static void main(String[] args) {


    }


    public static boolean isPalindrome(ListNode head) {


        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }


        int p1 = 0, p2 = list.size() - 1;
        while(p1<=p2){
            if(!list.get(p1++).equals(list.get(p2--))){
                return false;
            }


        }
        return true;

    }



    public static boolean isPalindrome2(ListNode head) {


        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }







/*Note:
* not so hard but I did not choose the method of space O(1) cuz I do not wanna modify the original list...
*
*
* */


}




