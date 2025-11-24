package Medium;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack155 {



    public static void main(String[] args) {


        /*
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/


        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());





    }


    /*
    *
    🔑 Key Idea:
        While you cannot maintain a fully sorted (ascending) array in O(1) time — because sorting or inserting in order requires work — you can maintain certain aggregated properties of the array in O(1) time with auxiliary data structures.

    ✅ What You Can Maintain in O(1)
        Here are some common examples you can maintain in constant time with smart structures:

        Property	Can be maintained in O(1)?	How
        Minimum value	✅ Yes	Use a secondary stack like in MinStack
        Maximum value	✅ Yes	Similar to MinStack, track maxStack
        Sum	✅ Yes	Keep a running total, update on push/pop
        Count	✅ Yes	Just increment/decrement a counter
        Average	✅ Yes	Track sum and count, then sum / count
        Prefix sum	✅ Amortized O(1)	Use prefix sum array (static) or Fenwick Tree
        Last element	✅ Yes	Last element of array/stack is always O(1)

    ❌ What You Cannot Maintain in O(1)

        Property	Why Not O(1)?
        Sorted array	Insertion requires finding the correct position + shifting
        k-th smallest/largest	Requires sorting or complex data structure (O(log n) or more)
        Median	Needs 2 heaps or balanced BST (O(log n))
        Mode (most frequent element)(加权平均数)	Need hash map with frequency counts, O(1) possible only with constraints

    *
    * */


    public static class MinStack {

        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> minStack=new ArrayList<>();

        public MinStack() {

        }

        public void push(int val) {

            list.add(val);
            if (minStack == null || minStack.size() == 0) {
                minStack.add(val);
            }
            else {
                minStack.add(Math.min(minStack.get(minStack.size()-1),val));
            }
        }

        public void pop() {
            int i=list.remove(list.size()-1);
            if(!minStack.isEmpty()){
                minStack.remove(minStack.size()-1);
            }
        }

        public int top() {
            return list.get(list.size()-1);
        }

        public int getMin() {
            return minStack.get(minStack.size()-1);
        }
    }




}
