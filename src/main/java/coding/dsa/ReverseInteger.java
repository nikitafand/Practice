package coding.dsa;

public class ReverseInteger {
    public static void main(String[] args) {
        int i = 1534236469;
        System.out.println(reverseInteger(i));

    }

    private static int reverseInteger(int i) {

        int temp = i, reverse = 0;
        while(temp != 0) {
            if(reverse > Integer.MAX_VALUE/10) return 0;
            reverse =  reverse*10 + temp%10 ;
            temp/=10;


        }

    return reverse;
    }
}
