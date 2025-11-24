package ToBeSolved;
public class CountOfMatchesInTournament1688 {

    public static void main(String[] args) {




        System.out.println(isCorrect());

    }


    public static boolean isCorrect(){

        for(int i=1;i<101;i++){
            if(numberOfMatches(i)!=i-1){
                System.out.println(numberOfMatches(i)+" "+i+" "+numberOfMatches(i-1));
              return false;
            }
        }

        return true;
    }

    public static int numberOfMatches(int n) {

        int count = 0;
        while(n>1){

            if(n%2==0){
                count+=n/2;
                n=n/2;
            }
            else{
                count+=(n/2)+1;
                n=n/2;
            }


        }
        return count;

    }

}
