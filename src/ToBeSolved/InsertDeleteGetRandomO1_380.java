package ToBeSolved;

import java.util.Random;

public class InsertDeleteGetRandomO1_380 {

/*
    public static class RandomizedSet {



        Integer[] array=new Integer[1000];

        public RandomizedSet() {

        }

        public boolean insert(int val) {

            int hashValue=Math.abs(val)%array.length;
            if(array[hashValue]!=null){
                while(array[hashValue]!=null){

                    if(array[hashValue].equals(val)){
                        return false;
                    }

                    hashValue++;
                }
                array[hashValue]=val;
                return true;
            }
            array[hashValue]=val;
            return true;
        }

        public boolean remove(int val) {
            int hashValue=Math.abs(val)%array.length;
            if(array[hashValue]==null){
                return false;
            }

            while(array[hashValue]!=null){
                if(array[hashValue].equals(val)){
                    array[hashValue]=null;
                    return true;
                }
                hashValue++;
            }
            return false;
        }

        public int getRandom() {
            Random random=new Random();


            int randomNumber=random.nextInt(1000);
            while(array[randomNumber]==null) {
                randomNumber=random.nextInt(1000);
            }

            return array[randomNumber];

        }Integer[] array=new Integer[1000];

        public RandomizedSet() {

        }

        public boolean insert(int val) {

            int hashValue=Math.abs(val)%array.length;
            if(array[hashValue]!=null){
                while(array[hashValue]!=null){

                    if(array[hashValue].equals(val)){
                        return false;
                    }

                    hashValue++;
                }
                array[hashValue]=val;
                return true;
            }
            array[hashValue]=val;
            return true;
        }

        public boolean remove(int val) {
            int hashValue=Math.abs(val)%array.length;
            if(array[hashValue]==null){
                return false;
            }

            while(array[hashValue]!=null){
                if(array[hashValue].equals(val)){
                    array[hashValue]=null;
                    return true;
                }
                hashValue++;
            }
            return false;
        }

        public int getRandom() {
            Random random=new Random();


            int randomNumber=random.nextInt(1000);
            while(array[randomNumber]==null) {
                randomNumber=random.nextInt(1000);
            }

            return array[randomNumber];

        }
    }

    */

    public static class RandomizedSet{
        Integer[] array=new Integer[1000];

        public RandomizedSet() {

        }


        public boolean insert(int val) {

            int hashValue=Math.abs(val)%array.length;
            if(array[hashValue]!=null){
                while(array[hashValue]!=null){

                    if(array[hashValue].equals(val)){
                        return false;
                    }

                    hashValue++;
                }
                array[hashValue]=val;
                return true;
            }
            array[hashValue]=val;
            return true;
        }

        public boolean remove(int val) {
            int hashValue=Math.abs(val)%array.length;
            if(array[hashValue]==null){

                for(int i=hashValue;i<hashValue+100;i++){
                    if(array[i]!=null && array[i].equals(val)){
                        array[i]=null;
                        return true;
                    }
                }

                return false;
            }

            while(array[hashValue]!=null){
                if(array[hashValue].equals(val)){
                    array[hashValue]=null;
                    return true;
                }
                hashValue++;
            }
            return false;
        }

        public int getRandom() {
            Random random=new Random();


            int randomNumber=random.nextInt(array.length+1);
            while(array[randomNumber]==null) {
                randomNumber=random.nextInt(array.length+1);
            }

            return array[randomNumber];

        }
    }


    public static void main(String[] args) {


        RandomizedSet randomizedSet= new RandomizedSet();
        randomizedSet.insert(20);







    }





}
