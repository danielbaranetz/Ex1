import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        assertEquals("101b2", Ex1.int2Number(5, 2), "b2 conversion failed");
        assertEquals("123", Ex1.int2Number(123, 10), "b10 conversion failed");
        assertEquals("222b8", Ex1.int2Number(146, 8), "b8 conversion failed");
        assertEquals("", Ex1.int2Number(-1, 2), "numbers should return an empty string");
        assertEquals("", Ex1.int2Number(10, 1), "base less than 2 should return an empty string");
        assertEquals("", Ex1.int2Number(10, 17), "base greater than 16 should return an empty string");
        assertEquals("0b2", Ex1.int2Number(0, 2), "conversion of 0 to base 2 failed");
        assertEquals("0bG", Ex1.int2Number(0, 16), "conversion of 0 to base 16 failed");
        assertEquals("0", Ex1.int2Number(0, 10), "conversion of 0 to base 10 failed");
        assertEquals("11111111b2", Ex1.int2Number(255, 2), "binary of 255 failed");
        assertEquals("FFbG", Ex1.int2Number(255, 16), "hexadecimal of 255 failed");
        assertEquals("10b2", Ex1.int2Number(2, 2), "conversion of 2 to base 2 failed");
        assertEquals("2bG", Ex1.int2Number(2, 16), "conversion of 2 to base 16 failed");

        System.out.println("All test cases passed.");
    }

    @Test
    void maxIndexTest() {
        String[] testArr = {"10bA","10bB","10100b2","1100100b2","99","1101b2","11111b2"};
        assertEquals(100, Ex1.maxIndex(testArr), "max index check failed");
    }

    // Add additional test functions - test as much as you can.
}