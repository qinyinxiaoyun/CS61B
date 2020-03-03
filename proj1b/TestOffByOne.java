import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new offByOne();
    @Test
    public void testOffByOne(){
        boolean b = offByOne.equalChars('a', 'b');
        assertEquals(offByOne.equalChars('a', 'b'), true);
    }
    static CharacterComparator offByN = new offByN(3);
    @Test
    public void testOffByN(){
        assertEquals(offByN.equalChars('a', 'd'), true);
    }
}