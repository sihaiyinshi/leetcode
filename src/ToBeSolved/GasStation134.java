package ToBeSolved;

public class GasStation134 {





    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        //System.out.println(canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {



        int min=0;

        for (int i = 0; i < gas.length; i++) {


            min+=i==0?gas[i]-cost[cost.length-1]:gas[i]-cost[i-1];

            if(gas[i]>=cost[i]){

                if(min>0){
                    return i;
                }


            }


        }


        return -1;

    }



}
