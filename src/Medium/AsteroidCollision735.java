package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidCollision735 {



    public static void main(String[] args) {


        //System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        //System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, 15, -20})));
        //System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-2,-2,1,-2})));
        //System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-2,-1,-2})));
        //System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
    }


    public static int[] asteroidCollision(int[] asteroids) {


        List<Integer> list = new ArrayList<>();







        int max = asteroids[0];
        list.add(max);
        for(int i=1;i<asteroids.length;i++){

            if(asteroids[i]*max>0){
                list.add(asteroids[i]);
                max=Math.max(max,asteroids[i]);
            }
            else if(max<0){
                max=asteroids[i];
                list.add(max);
            }
            else if(max>0){


                



                /*
                if(-asteroids[i]<max){

                    int temp=list.size()-1;
                    while(list.get(temp)<=-asteroids[i]){
                        temp--;
                    }

                    list=list.subList(0,temp+1);
                    max=list.isEmpty()?0:list.get(list.size()-1);


                }
                else if(-asteroids[i]>max){

                    list.clear();
                    max=asteroids[i];
                    list.add(max);


                }
                else if(-asteroids[i]==max){
                    list=list.subList(0,list.indexOf(max));
                    max=list.isEmpty()?0:list.get(list.size()-1);
                }*/

            }


        }





        return list.stream().mapToInt(i->i).toArray();
    }



}
