import org.junit.Test;

import static org.junit.Assert.*;

public class TestAssertion {

    @Test
    public void testAssertions(){
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = null;
        String s4 = "abc";
        String s5 = "abc";

        int v1 = 5;
        int v2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        assertEquals(s1,s2);

        assertTrue(v1 < v2);

        assertFalse(v1 > v2);

        assertNotNull(s1);

        assertNull(s3);

        assertSame(s4, s5);

        assertNotSame(s1, s3);

        assertArrayEquals(expectedArray, resultArray);
    }
}
