package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {
    public static void main(String[] args) {
        String name = "myNameisJavaStreams";
        Map<String, Long> map = Arrays
                .stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        List<String> duplicateElements = map.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicateElements);

        List<String> uniqueElements = map.entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(uniqueElements);


        Optional<String> first = uniqueElements.stream().findFirst();
        System.out.println(first);

        Map<String, Long> linkedHashmap = Arrays
                .stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        List<String> orderedUniqueElements = linkedHashmap.entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(orderedUniqueElements.stream().findFirst());
    }
}
