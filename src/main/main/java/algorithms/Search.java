package algorithms;

import java.util.*;

public class Search {
    static int indexOfItem(List<String> list, String target) {
        int first = 0;
        int last = list.size() - 1;
        while (first <= last) {
            int midpoint = (first + last) / 2;
            int comparisonResult = list.get(midpoint).compareTo(target);
            if (comparisonResult == 0) {
                return midpoint;
            } else if (comparisonResult < 0) {
                first = midpoint + 1;
            } else {
                last = midpoint - 1;
            }
        }
        // We have to return an integer, so return an "impossible"
        // index to indicate value was not found.
        return -1;
    }

    public static void main(String[] args) {
        // Note that the list is sorted this time!
        ArrayList<String> list = new ArrayList<String>(
                Arrays.asList("Elida Sleight", "Francina Vigneault", "Lucie Hansman", "Nancie Rubalcaba"));
        System.out.println(indexOfItem(list, "Lucie Hansman"));
    }
}