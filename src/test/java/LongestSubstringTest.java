import junit.framework.TestCase;
import org.junit.Test;

public class LongestSubstringTest extends TestCase {


    @Test
    public void testLongestSubstring(){
        StringOperations stringOperations = new StringOperations();
        int length = stringOperations.lengthOfLongestSubstring("abcabcd");

        assertEquals(4, length);


        length = stringOperations.lengthOfLongestSubstring("pwwkew");

        assertEquals(3, length);
    }
}