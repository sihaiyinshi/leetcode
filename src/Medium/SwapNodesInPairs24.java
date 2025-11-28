package Medium;

public class SwapNodesInPairs24 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public static void main(String[] args){




        //System.out.println(swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))))));
        //System.out.println(swapPairs(new ListNode(1,new ListNode(2,new ListNode(3)))));
        //System.out.println(swapPairs(new ListNode(1)));
        System.out.println(swapPairs(null));
    }


    public static ListNode swapPairs(ListNode head) {


        if(head==null || head.next==null){
            return head;
        }


        ListNode slow = head;
        ListNode fast = head.next;
        head=head.next;
        ListNode prev=null;

        while(true){

            ListNode next=fast.next;
            fast.next=slow;
            slow.next=next;

            if(prev!=null){
                prev.next=fast;
            }

            if(next==null || next.next==null){
                break;
            }

            prev=slow;
            slow=next;
            fast=next.next;

        }


        return head;








    }


}
