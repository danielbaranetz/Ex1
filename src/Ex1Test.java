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
            assertEquals("1010b2", Ex1.int2Number(10, 2));
            assertEquals("B", Ex1.int2Number(10, 16));
            assertEquals("10", Ex1.int2Number(10, 10));
            assertEquals("12b8", Ex1.int2Number(10, 8));
            assertEquals("111b3", Ex1.int2Number(13, 3));

            assertEquals("", Ex1.int2Number(-5, 10));
            assertEquals("", Ex1.int2Number(5, 1));
            assertEquals("", Ex1.int2Number(5, 17));

            assertEquals("0", Ex1.int2Number(0, 2));
            assertEquals("0", Ex1.int2Number(0, 10));
            assertEquals("0", Ex1.int2Number(0, 16));
            assertEquals("1", Ex1.int2Number(1, 10));
            assertEquals("1b2", Ex1.int2Number(1, 2));
    }

    @Test
    void maxIndexTest() {
        // implement this test
    }

    // Add additional test functions - test as much as you can.
}