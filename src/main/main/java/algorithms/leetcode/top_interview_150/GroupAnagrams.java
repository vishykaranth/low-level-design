package algorithms.leetcode.top_interview_150;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] input2 = {"a"};
        System.out.println(groupAnagrams(input2));
    }

    public static List<List<String>> groupAnagrams(String[] input) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : input) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                List<String> strings = map.get(key);
                strings.add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(key, strings);
            }
        }
        List<List<String>> result = new ArrayList(map.values());
        return result;
    }
}
