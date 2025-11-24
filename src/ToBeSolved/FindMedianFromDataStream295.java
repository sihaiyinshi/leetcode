package ToBeSolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {


    public static class MedianFinder {





        List<Integer> list=new ArrayList<>();

        private static void quickSort(int[] array, int left, int right){
            if(left>=right){
                return;
            }

            int part=partition(array, left, right);
            quickSort(array, left, part-1);
            quickSort(array, part+1, right);


        }


        private static int partition(int[] array, int left, int right){
            int pivot = array[right];
            int i = left;


            for(int j=left;j<right;j++){
                if(array[j]<pivot){
                    if(i==j){
                        i++;
                    }
                    else{
                        int temp= array[i];
                        array[i++]=array[j];
                        array[j]=temp;
                    }
                }
            }


            int temp= array[i];
            array[i]=array[right];
            array[right]=temp;
            return i;

        }

        public MedianFinder() {

        }

        public void addNum(int num) {

            list.add(num);

        }

        public double findMedian() {

            Integer[] array= list.toArray(new Integer[0]);
            Arrays.sort(array);

            return array.length%2==0?((double)array[array.length/2]+array[(array.length/2)-1])/2:(double)array[array.length/2];

        }




    }

    public static void main(String[] args) {
        
        
        

        MedianFinder mf=new MedianFinder();
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());

    }





}
