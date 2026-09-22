package coding.dsa;

import java.util.*;

public class TopKFrequentElements {
    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) {
         String str= "programminggg";
         calculateFrequency(str);
        findtopKFrequentElements(map, 2);
    }

    private static void findtopKFrequentElements( Map<Character, Integer> map, int i) {

       List<Character>[] buckets= new ArrayList[10];
       for(char m: map.keySet()){
         int val= map.get(m);
         if(buckets[val]==null){
             buckets[val]= new ArrayList<>();
         }
          buckets[val].add(m);
       }
        char[] topk= new char[i];
        int index=0;
       for(int j = buckets.length-1; j>=0 &&  index < i; j-- ){
           if(buckets[j]!=null){
               for(char k: buckets[j]){
                   topk[index++]= k;
                   if(i==index){
                       break;
                   }
               }
           }
       }
        System.out.println(Arrays.toString(topk));
    }

    private static void calculateFrequency(String str) {



        char[] arr = str.toCharArray();
        int i = 0;
        while(i < arr.length){
            map.put(arr[i] , map.getOrDefault(arr[i],0 )+1 );
            i++;
        }
        System.out.println(map.toString());
    }
}
