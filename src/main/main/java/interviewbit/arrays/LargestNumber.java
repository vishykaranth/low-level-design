package interviewbit.arrays;//https://www.interviewbit.com/problems/largest-number/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        ArrayList<String> str = new ArrayList<String>();
        for (int i = 0; i < A.size(); i++)
            str.add(Integer.toString(A.get(i)));
        Collections.sort(str, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < str.size(); i++)
            strb.append(str.get(i));
        BigInteger bigIntegerStr = new BigInteger(strb.toString());
        if (bigIntegerStr.intValue() == 0)
            return "0";
        return strb.toString();
    }
}
