package interviewbit.arrays;//https://www.interviewbit.com/problems/noble-integer/

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        for (int i = 0; i < n; i++) {
            while (i < n - 1 && A.get(i) == A.get(i + 1))
                i++;
            if (A.get(i) == (n - i - 1))
                return 1;
        }
        return -1;
    }
}
