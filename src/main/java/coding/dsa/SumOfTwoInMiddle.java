package coding.dsa;


import java.util.ArrayList;
import java.util.List;

public class SumOfTwoInMiddle {

    public static void main(String[] args) {
        int zero= 123/100;
        displayNumbersList(100, 200);
    }

    private static void displayNumbersList(int i, int i1) {
List<Integer> result = new ArrayList<>();
        for (int j = i; j < i1; j++) {
             int zero= j/100;
             int one= (j / 10) % 10;
              int two= (j) % 10;
               if(zero + two == one){
                  result.add(j);
               }


        }
        System.out.println(result);
    }
}
