package coding.dsa;

public class FizzBuzz {

    public static void main(String[] args) {
        int num= 15;
        printFizzBuzz(num);
    }

    private static void printFizzBuzz(int num) {


         if(num%3==0 && num%5==0){
             System.out.println("FizzBuzz");
         }
    }
}
