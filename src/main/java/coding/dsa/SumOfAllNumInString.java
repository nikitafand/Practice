package coding.dsa;

public class SumOfAllNumInString
{
    public static void main(String[] args) {
        String s = "abc210LJTTIE1624HELLO25";
        int sum = 0;
        String num = "";
       for(char c:s.toCharArray()){
           if(Character.isDigit(c)){
               num+=c;
           }else {
               if(!num.isEmpty()){
                   sum+= Integer.parseInt(num);
                   num= "";
               }

           }
       }
        System.out.println(sum);
    }
}
