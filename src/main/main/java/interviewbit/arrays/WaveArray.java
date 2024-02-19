package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size(); i += 2) {
            if (i + 1 < A.size())
                Collections.swap(A, i, i + 1);
        }
        return A;
    }
}
