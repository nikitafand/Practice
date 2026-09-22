package coding.dsa;

import java.util.*;


public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
       List<List<String>> res=  groupAnagrams(strs);
       System.out.println(res);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= null;
        if(strs==null||strs.length==0){
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
        int[] count   = new int[26];
            for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int freq : count) {
                sb.append('#').append(freq);
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

        }
        return map.values().stream().toList();
    }
}
