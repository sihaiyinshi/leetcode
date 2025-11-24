package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations46 {




    public static void main(String[] args) {



        System.out.println(permute(new int[]{1, 2, 3}));
    }


    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> remains=new ArrayList<>();
        for(int num:nums){
            remains.add(num);
        }

        List<List<Integer>> num=new ArrayList<>();
        permute(num,remains);
        return num;

    }


    public static void permute(List<List<Integer>> nums,List<Integer> remains) {

        if(remains.isEmpty()){
            return;
        }
        else if(remains.size() == 1){
            for(List list:nums){

                list.add(remains.get(0));

            }
            return;
        }


        for(Integer remain:remains){

            for(List list:nums){
                list.add(remain);
            }

            List<Integer> newRemains = remains;
            newRemains.remove(remain);

            permute(nums, newRemains);

        }


    }







}
