package Easy;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * */

public class ReverseLinkedList206 {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


        public String toString() {
          return ""+this.val;
        }
    }


  public static void main(String[] args) {


        ListNode n3=new ListNode(3);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);


        //System.out.println(n1);
        reverseBetween2(n1);
        System.out.println(n3);
        //System.out.println(n3);
        //System.out.println(n1);


  }

  public static ListNode reverseBetween(ListNode head) {


        ListNode prev = null;


        while(head != null) {

            if(prev!=null) {
                if(head.next!=null) {
                    ListNode temp = head.next;
                    head.next=prev;
                     prev=head;
                     head=temp;
                }
                else {
                    head.next=prev;
                    break;
                }
            }
            else if(head.next!=null){
                ListNode temp = head.next;
                prev=head;
                prev.next=null;
                head=temp;
            }
            else{
                return head;
            }

        }

    return head;

  }


    public static ListNode reverseBetween2(ListNode head) {

        if(head.next!=null) {

            ListNode temp = head.next;
            head.next=null;
            return reverseBetweenRecursive(temp,head);

        }
        else{
            return head;
        }




    }


    public static ListNode reverseBetweenRecursive(ListNode head, ListNode prev) {

        if(head.next!=null){
            ListNode temp = head.next;
            head.next=prev;
            prev=head;
            return reverseBetweenRecursive(temp,prev);
        }
        else{
            head.next=prev;
            return head;
        }


    }


  /*Note: this can be solved either recursive or in loop
  *
  * */


}
