package interviewbit.arrays;//https://www.interviewbit.com/problems/maximum-absolute-difference/

import java.util.ArrayList;
import java.util.Collections;

public class MaxAbsDiff {
    public int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> addi = new ArrayList<Integer>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            addi.add(A.get(i) + i);
            sub.add(A.get(i) - i);
        }
        Collections.sort(addi);
        Collections.sort(sub);
        return (Math.max((addi.get(n - 1) - addi.get(0)), (sub.get(n - 1) - sub.get(0))));
    }
}
