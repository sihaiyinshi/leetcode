package ToBeSolved;

import java.util.ArrayList;
import java.util.List;
public class EverythingAboutPermutation {


    public static void main(String[] args) {

        /*
        List<List<Integer>> list=AllPermutation(new int[]{1,2,3,4});

        for(List<Integer> i:list){
            System.out.println(i);
        }*/

    }




    /*
    public static List<List<Integer>> AllPermutation(int[] nums) {
        ArrayList<List<Integer>> list=new ArrayList<>();
        List<Integer> queue=new ArrayList<>();
        boolean[] temp=new boolean[nums.length];
        findAllPermutation(list, queue, temp, nums, 0);
        return list;

    }





    public static void findAllPermutation(List<List<Integer>> list, List<Integer> queue,boolean[] temp, int[] nums, int index) {

        if(index== nums.length) {
            list.add(queue);
        }
        else{
            for(int i = 0; i < nums.length; i++) {
                if(temp[i]) continue;
                queue.add(nums[i]);
                temp[i] =true;
                findAllPermutation(list, queue, temp, nums, index+1);
                temp[i] = false;
                queue.remove(index);
            }
        }
    }
*/


    public static void swap(){



    }


    public static void findAllPermutation(List<List<Integer>> list,  int[] nums, int start, int end) {





    }



}