package longestsubstring;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LongestSubstringTest {

    public LongestSubstringTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of {@link LongestSubstring#find(java.lang.String, int)}.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        assertEquals("", new LongestSubstring("food", 0).find());
        assertEquals("foo", new LongestSubstring("food", 2).find());
        assertEquals("anana", new LongestSubstring("bananas", 2).find());
        assertEquals("anana", new LongestSubstring("banana", 2).find());
    }

    /**
     * Test of {@link LongestSubstring#satisfies(int, int)}.
     */
    @Test
    public void testSatisfies() {
        System.out.println("satisfies");
        assertTrue(new LongestSubstring("food", 0).satisfies(0, 0));
        assertTrue(new LongestSubstring("food", 0).satisfies(4, 4));
        assertTrue(new LongestSubstring("food", 2).satisfies(3, 2));
        assertFalse(new LongestSubstring("food", 0).satisfies(0, 1));
        assertTrue(new LongestSubstring("food", 1).satisfies(0, 0));
        assertTrue(new LongestSubstring("food", 1).satisfies(0, 1));
        assertTrue(new LongestSubstring("food", 2).satisfies(0, 2));
        assertTrue(new LongestSubstring("food", 2).satisfies(0, 3));
        assertFalse(new LongestSubstring("food", 2).satisfies(0, 4));
        assertTrue(new LongestSubstring("food", 2).satisfies(1, 4));
        assertTrue(new LongestSubstring("food", 1).satisfies(1, 3));
        assertFalse(new LongestSubstring("food", 1).satisfies(1, 4));
        assertTrue(new LongestSubstring("food", 1).satisfies(2, 3));
        assertFalse(new LongestSubstring("food", 1).satisfies(2, 4));
        assertTrue(new LongestSubstring("food", 1).satisfies(3, 4));
    }
}
