import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> pal = new ArrayDeque<Character>();
        for (int i = 0; i < word.length();i += 1){
            pal.addLast(word.charAt(i));
        }
        return pal;
    }
    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        String reverse = "";
        for (int i = 0; i < word.length(); i++) {
            reverse += d.removeLast();
        }
        return word.equals(reverse);
    }
    @Test
    public void TestPalindrome(){
        boolean t = isPalindrome("string");
        assertEquals(false, t);
    }
}
