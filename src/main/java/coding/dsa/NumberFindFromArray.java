package coding.dsa;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class NumberFindFromArray {

    public static void main(String[] args) {

        List<String> arr= List.of("abc", "123", "as1");

        List<Integer> res = arr.stream().filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(res);

        List<Integer> st= List.of(1,2,3,4,4, 4,5);
        Integer reduce = st.stream().reduce(0, Integer::sum);
        int sum = st.stream().mapToInt(Integer::intValue).sum();
        Map<Integer, Long> co= st.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
