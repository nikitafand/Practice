package coding.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceError {
    public static void main(String[] args) {
        String[] input = {"x:a", "x:b", "y:c", "y:c", "y:b"};
        Map<String, String> errorMap = mostFrequentErrors(input);
        System.out.println(errorMap);
    }

    private static Map<String, String> mostFrequentErrors(String[] logs) {
        Map<String, Map<String, Integer>> serviceErrorCodeCount = new ConcurrentHashMap<>();
        for (String input : logs) {
            String[] split = input.split(":");
            String service = split[0];
            String errorCode = split[1];

            Map<String, Integer> errorCodeMap = serviceErrorCodeCount.computeIfAbsent(service, k -> new ConcurrentHashMap<>());
            errorCodeMap.put(errorCode, errorCodeMap.getOrDefault(errorCode, 0) + 1);
            //serviceErrorCodeCount.put(service, errorCodeMap);
        }
        Map<String, String> result = new HashMap<>();
        System.out.println("before");
        System.out.println(serviceErrorCodeCount);
//        serviceErrorCodeCount.forEach((s, map) -> {
//            serviceErrorCodeCount.remove(s);
//        });
        System.out.println("after");
        System.out.println(serviceErrorCodeCount);
        serviceErrorCodeCount.entrySet().forEach(entry -> {
            String service = entry.getKey();
            Map<String, Integer> value = entry.getValue();
            Optional<Map.Entry<String, Integer>> first = value.entrySet().stream()
                    .sorted((e1, e2) -> {
                if (e1.getValue() != e2.getValue()) return e2.getValue().compareTo(e1.getValue());
                else return e1.getKey().compareTo(e2.getKey());
            }).findFirst();
            first.ifPresent(stringIntegerEntry -> result.put(service, stringIntegerEntry.getKey()));

        });
        return result;
    }
}
